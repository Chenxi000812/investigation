package com.chenxi.investigation.controller;

import com.chenxi.investigation.domain.model.Ansower;
import com.chenxi.investigation.service.PublicService;
import com.chenxi.investigation.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    PublicService publicService;
    @PostMapping("/investigation/{u}/upload")
    public void uploadInvestigation(@RequestBody List<Ansower> ansowers,@PathVariable(name = "u")String u){
        publicService.addAnsower(ansowers,u);
    }
}
