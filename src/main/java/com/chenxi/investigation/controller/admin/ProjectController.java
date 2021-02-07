package com.chenxi.investigation.controller.admin;

import com.chenxi.investigation.domain.model.Options;
import com.chenxi.investigation.domain.model.Questionnaire;
import com.chenxi.investigation.domain.model.Questions;
import com.chenxi.investigation.domain.model.Sysuser;
import com.chenxi.investigation.service.AdminService;
import com.chenxi.investigation.util.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/project")
public class ProjectController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/questionnaire")
    public AjaxResult queryQuestionnaire(Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        PageInfo pageInfo = new PageInfo(adminService.queryQuestionnaire());
        return AjaxResult.me().setCount(pageInfo.getTotal()).setData(pageInfo.getList());
    }

    @PostMapping(value = "/questionnaire")
    public AjaxResult addQuestionnaire(Authentication authentication,Questionnaire questionnaire){
        Sysuser sysuser = (Sysuser) authentication.getPrincipal();
        questionnaire.setCreateuser(sysuser.getId());
        if (adminService.addQuestionnaire(questionnaire)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }

    @PutMapping(value = "/questionnaire")
    public AjaxResult updateQuestionnaire(Questionnaire questionnaire){
        if (adminService.updateQuestionnaire(questionnaire)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }
    @DeleteMapping(value = "/questionnaire")
    public AjaxResult delQuestionnaire(Questionnaire questionnaire){
        if (adminService.delQuestionnaire(questionnaire)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }

    @GetMapping(value = "/questions")
    public AjaxResult queryQuestions(Integer qid,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        PageInfo pageInfo = new PageInfo(adminService.queryQuestions(qid));
        return AjaxResult.me().setCount(pageInfo.getTotal()).setData(pageInfo.getList());
    }

    @PostMapping(value = "/questions")
    public AjaxResult addQuestions(Questions questions,String[] option){
        if (adminService.addQuestions(questions,option)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }
    @DeleteMapping(value = "/questions")
    public AjaxResult delQuestions(@RequestBody List<Questions> questions){
        if (questions.size() < 1 ||adminService.delQuestions(questions)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }

    @PutMapping(value = "/questions")
    public AjaxResult updateQuestions(Questions questions){
        if (adminService.updateQuestions(questions)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }

    @GetMapping(value = "/options")
    public AjaxResult queryOptions(Long qid,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        PageInfo pageInfo = new PageInfo(adminService.queryOptions(qid));
        return AjaxResult.me().setCount(pageInfo.getTotal()).setData(pageInfo.getList());
    }
    @PostMapping(value = "/options")
    public AjaxResult addOptions(Long questionid,String[] option){
        try {
            adminService.addOptions(questionid,option);
            return AjaxResult.me();
        }catch (Exception e){
            return AjaxResult.me().setCode(-1);
        }
    }
    @DeleteMapping(value = "/options")
    public AjaxResult delOptions(@RequestBody List<Options> options){
        if (options.size() < 1 || adminService.delOptions(options)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }
    @PutMapping(value = "/options")
    public AjaxResult updateOptions(Options options){
        if (adminService.updateOptions(options)==0){
            return AjaxResult.me().setCode(-1);
        }
        return AjaxResult.me();
    }
}
