package edu.mum.tm.controller;

import edu.mum.tm.domain.Entry;
import edu.mum.tm.domain.TmRetread;
import edu.mum.tm.service.TmAddRetreatService;
import edu.mum.tm.service.TmDeleteRetreatService;
import edu.mum.tm.service.TmRetreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user", "loggedPerson"})
public class TmRetreatController {

    @Autowired
    private TmRetreatService tmRetreatService;

    @Autowired
    private TmAddRetreatService tmAddRetreatService;

    @Autowired
    private TmDeleteRetreatService tmDeleteRetreatService;

    @GetMapping("/admin/tmretreat")
    public String getTMRetreatForm( Model model){
        model.addAttribute("entries",tmRetreatService.getAll());
        return "TmCheckReport";
    }


    @PostMapping("/admin/tmretreat")
    public String postTMRetreatForm(@ModelAttribute("TmRetread") TmRetread retread, Model model){
        tmAddRetreatService.add(retread.getStudentId(),retread.getDate());
        model.addAttribute("entries", tmRetreatService.getAll());
        return "TmCheckReport";
    }

    @PostMapping("/admin/deleteitem")
    public String postDeleted(@ModelAttribute("TmRetread") TmRetread retread, Model model){

        tmDeleteRetreatService.deleteItem(retread.getStudentId(),retread.getDate());
        model.addAttribute("entries", tmRetreatService.getAll());
        return "TmCheckReport";
    }

}
