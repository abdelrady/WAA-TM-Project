package edu.mum.tm.controller;

import edu.mum.tm.domain.*;
import edu.mum.tm.service.FileProcessingService;
import edu.mum.tm.service.StudentService;
import edu.mum.tm.service.TmAttendanceService;
import net.bytebuddy.asm.Advice;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"user", "loggedPerson"})
@EnableAsync
public class TMSubmitterController {
    String content = "";
    //BufferedReader br;
    String filePath;
    Integer procId = 0;

    private Logger log = Logger.getLogger(getClass());

    @Autowired
    private StudentService studentService;

    @Autowired
    private TmAttendanceService tmAttendanceService;

    @Autowired
    private FileProcessingService fileProcessingService;

    @GetMapping("/admin/TM")
    public String getTMSubmitForm(@ModelAttribute("newEntry") Entry entry, Model model, HttpServletRequest request){
        request.setAttribute("procId", 0);
        return "TM/index";
    }
    public void logError(Exception ex) {

        StringWriter stack = new StringWriter();
        ex.printStackTrace(new PrintWriter(stack));
        log.error("----------------------------------------------------------");
        log.error(stack.toString());
        log.error("----------------------------------------------------------");
    }
    @PostMapping("/admin/AddTMFile")
    public String submitTMFile(@RequestParam("TMFile") MultipartFile file, Model model, HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        filePath = request.getServletContext().getRealPath("/") + "TempFile\\";// + LocalDateTime.now().format(formatter);

        try{
            //content = new String(file.getBytes(), "UTF-8");
            //InputStream is = file.getInputStream();
            //br = new BufferedReader(new InputStreamReader(is));

            if(! new File(filePath).exists())
            {
                new File(filePath).mkdir();
                filePath = filePath + LocalDateTime.now().format(formatter);
                if(! new File(filePath).exists())
                {
                    new File(filePath).mkdir();
                }
            }
            else
            {

                filePath = filePath + LocalDateTime.now().format(formatter);
                if(! new File(filePath).exists())
                {
                    new File(filePath).mkdir();
                }
            }
            filePath = filePath + "\\" + file.getOriginalFilename();
            file.transferTo(new File(filePath ));

            FileProcessing fileEntry = new FileProcessing();
            fileEntry.setDone(false);
            fileEntry.setStartTime(LocalDateTime.now());
            fileEntry.setProcessed(0);
            fileEntry.setRowsCount(0);


            fileProcessingService.addFileProcessing(fileEntry);
            procId = fileEntry.getId();
            System.out.println(procId);
        }
        catch (Exception ex){
            content = ex.getMessage();
            logError(ex);
        }
        new Thread(new Runnable(){
            @Override
            public void run(){
                addTMFile(filePath, procId);
            }
        }).start();
        request.setAttribute("procId", procId);
        return "TM/index";
    }

    @Async
    void addTMFile(String filePath, Integer procId) {
        int procRecsCounter =0, totalRows = 0;

        System.out.println(procId);
        try {
            Thread.sleep(500);

            FileSystemResource resource = new FileSystemResource(filePath);
            File f =resource.getFile();

            FileProcessing fileProcEntry = fileProcessingService.getById(procId);

            BufferedReader b = new BufferedReader(new FileReader(f));

            //SimpleDateFormat sFormat = new SimpleDateFormat("MM/dd/yy");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
            String line;
            int i =1;
            while ((line = b.readLine()) != null) {
                totalRows++;
                try {
                    System.out.println("Linke "  + i++ + " : ");
                    //System.out.println(line);
                    String[] lineData = line.split(",");
                    TmAttendance entry = new TmAttendance();

                    Student s = studentService.getStudentByMumId(Long.parseLong(lineData[0]));
                    entry.setStudent(s);

                    //Date day = sFormat.parse(lineData[1]);

                    entry.setDate(LocalDate.parse(lineData[1], formatter));

                    entry.setType(lineData[2] == "EAM" ? TmTimeSlot.EAM : TmTimeSlot.AM);

                    entry.setLocation(lineData[3]);

                    if(s != null)
                    {
                        tmAttendanceService.addTmAttendance(entry);
                        procRecsCounter++;
                    }

                    fileProcEntry.setProcessed(procRecsCounter);
                    fileProcEntry.setRowsCount(totalRows);
                    fileProcessingService.Save(fileProcEntry);
                }
                catch (Exception e){
                    logError(e);
                    System.out.println(e);
                }

                fileProcEntry.setDone(true);
                fileProcEntry.setEndTIme(LocalDateTime.now());
                fileProcessingService.Save(fileProcEntry);

            }

        }
        catch (Exception ex){

            System.out.println(ex.getMessage());
        }

    }





    @PostMapping("/admin/AddManualTMFile")
    public String submitMTMFile(@RequestParam("TMFile") MultipartFile file, Model model, HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        filePath = request.getServletContext().getRealPath("/") + "TempFile\\";// + LocalDateTime.now().format(formatter);

        try{

            if(! new File(filePath).exists())
            {
                new File(filePath).mkdir();
                filePath = filePath + LocalDateTime.now().format(formatter);
                if(! new File(filePath).exists())
                {
                    new File(filePath).mkdir();
                }
            }
            else
            {

                filePath = filePath + LocalDateTime.now().format(formatter);
                if(! new File(filePath).exists())
                {

                    new File(filePath).mkdir();
                }
            }

            filePath = filePath + "\\" + file.getOriginalFilename();
            file.transferTo(new File(filePath ));

            FileProcessing fileEntry = new FileProcessing();
            fileEntry.setDone(false);
            fileEntry.setStartTime(LocalDateTime.now());
            fileEntry.setProcessed(0);
            fileEntry.setRowsCount(0);


            fileProcessingService.addFileProcessing(fileEntry);
            procId = fileEntry.getId();
            System.out.println(procId);
        }
        catch (Exception ex){
            content = ex.getMessage();
        }
        new Thread(new Runnable(){
            @Override
            public void run(){
                addMTMFile(filePath, procId);
            }
        }).start();
        request.setAttribute("procId", procId);
        return "TM/index";
    }

    @Async
    void addMTMFile(String filePath, Integer procId) {


        int procRecsCounter =0, totalRows = 0;

        System.out.println(procId);
        try {
            Thread.sleep(500);

            FileSystemResource resource = new FileSystemResource(filePath);
            File f =resource.getFile();

            FileProcessing fileProcEntry = fileProcessingService.getById(procId);

            BufferedReader b = new BufferedReader(new FileReader(f));

            //SimpleDateFormat sFormat = new SimpleDateFormat("MM/dd/yyyy");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String line;
            int i =1;
            while ((line = b.readLine()) != null) {
                totalRows++;
                try {
                    System.out.println("Linke "  + i++ + " : ");
                    //System.out.println(line);
                    String[] lineData = line.split(",");
                    TmAttendance entry = new TmAttendance();

                    long sid = 0;
                    //Long.parseLong();
                    String sidString = lineData[1];
                    String[] sidStringParts = sidString.split("-");
                    sid = Long.parseLong(sidStringParts[2]);
                    sid += 10000 * Long.parseLong(sidStringParts[1]);
                    sid += 1000000 * Long.parseLong(sidStringParts[0]);

                    Student s = studentService.getStudentByMumId(sid);
                    entry.setStudent(s);

                    //Date day = sFormat.parse(lineData[1]);

                    entry.setDate(LocalDate.parse(lineData[0], formatter));

                    entry.setType(TmTimeSlot.Manual);

                    entry.setLocation("--");

                    if(s != null)
                    {
                        tmAttendanceService.addTmAttendance(entry);
                        procRecsCounter++;
                    }

                    fileProcEntry.setProcessed(procRecsCounter);
                    fileProcEntry.setRowsCount(totalRows);
                    fileProcessingService.Save(fileProcEntry);
                }
                catch (Exception e){
                    System.out.println(e);
                }

                fileProcEntry.setDone(true);
                fileProcEntry.setEndTIme(LocalDateTime.now());
                fileProcessingService.Save(fileProcEntry);

            }

        }
        catch (Exception ex){

            System.out.println(ex.getMessage());
        }


    }
}
