package edu.mum.tm.controller;

import edu.mum.tm.domain.FileProcessing;
import edu.mum.tm.service.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class TMRestService   {

    @Autowired
    private FileProcessingService fileProcessingService;

    @PostMapping( value = "/admin/CheckTMFile", produces = "application/json")
    public FileProcessing checkFileProc(HttpServletRequest request){

        //@RequestBody int proc
        try {
            long proc = Long.parseLong(request.getParameter("proc"));
            //1;
            FileProcessing fileProcEntry = fileProcessingService.getById(proc);


            return fileProcEntry;
        }
        catch (Exception ex){
            return null;
        }
    }
}
