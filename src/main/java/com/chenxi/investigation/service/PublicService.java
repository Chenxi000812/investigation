package com.chenxi.investigation.service;

import com.chenxi.investigation.domain.dao.AnsowerMapper;
import com.chenxi.investigation.domain.dao.AnsowerformMapper;
import com.chenxi.investigation.domain.dao.QuestionnaireMapper;
import com.chenxi.investigation.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PublicService {
    @Autowired
    QuestionnaireMapper questionnaireMapper;
    @Autowired
    AnsowerMapper ansowerMapper;
    @Autowired
    AnsowerformMapper ansowerformMapper;

    public Questionnaire getInvestigation(String url) {
        return questionnaireMapper.findByUrl(url);
    }

    public void addAnsower(List<Ansower> ansower, String url) {
        QuestionnaireExample questionnaireExample = new QuestionnaireExample();
        QuestionnaireExample.Criteria criteria = questionnaireExample.createCriteria();
        criteria.andUrlEqualTo(url);
        List<Questionnaire> questionnaires = questionnaireMapper.selectByExample(questionnaireExample);
        Ansowerform ansowerform = new Ansowerform();
        if (questionnaires.size()==1){
            ansowerform.setCreatetime(new Date());
            ansowerform.setQuestionnaireid(questionnaires.get(0).getId());
            ansowerformMapper.insertSelective(ansowerform);
            List<Ansower> an = new ArrayList<>();
            for (Ansower a: ansower){
                a.setFormid(ansowerform.getId());
                an.add(a);
            }
            ansowerMapper.insertList(an);
        }
    }
}
