package com.chenxi.investigation.controller;
import com.chenxi.investigation.domain.model.Questionnaire;
import com.chenxi.investigation.domain.model.Sysuser;
import com.chenxi.investigation.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    PublicService publicService;

    @RequestMapping("/admin/index")
    public String questionnaire(Authentication authentication,Model model){
        if (authentication!=null){
            Sysuser sysuser = (Sysuser) authentication.getPrincipal();
            sysuser.getUsername();
            model.addAttribute("userName",sysuser.getUsername());
        }
        return "admin/index";
    }

    @RequestMapping("/admin/login")
    public String login(){
        return "admin/login";
    }

    @RequestMapping("/public/investigation/{u}")
    public String investigation(@PathVariable(name = "u") String url,Model model){
        Questionnaire questionnaire = publicService.getInvestigation(url);
        if (questionnaire==null||questionnaire.getStatus()==1){
            return "404";
        }
        model.addAttribute("q",questionnaire);
        return "public/index";
    }

}
