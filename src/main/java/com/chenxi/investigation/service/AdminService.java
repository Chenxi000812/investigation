package com.chenxi.investigation.service;

import com.chenxi.investigation.domain.dao.*;
import com.chenxi.investigation.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AdminService {

    @Autowired
    QuestionnaireMapper questionnaireMapper;

    @Autowired
    QuestionsMapper questionsMapper;

    @Autowired
    OptionsMapper optionsMapper;

    @Autowired
    AnsowerMapper ansowerMapper;

    @Autowired
    AnsowerformMapper ansowerformMapper;

    public List<Questionnaire> queryQuestionnaire() {
        return questionnaireMapper.selectByExample(null);
    }

    public int addQuestionnaire(Questionnaire questionnaire) {
        questionnaire.setCreatetime(new Date());
        questionnaire.setUpdatetime(new Date());
        UUID uuid = UUID.randomUUID();
        questionnaire.setUrl(uuid.toString().replaceAll("-",""));
        return questionnaireMapper.insertSelective(questionnaire);
    }

    public int updateQuestionnaire(Questionnaire questionnaire) {
        questionnaire.setUpdatetime(new Date());
        return questionnaireMapper.updateByPrimaryKeySelective(questionnaire);
    }

    public int delQuestionnaire(Questionnaire questionnaire) {
        AnsowerformExample ansowerformExample = new AnsowerformExample();
        AnsowerformExample.Criteria criteria = ansowerformExample.createCriteria();
        criteria.andQuestionnaireidEqualTo(questionnaire.getId());
        List<Questions> questions = queryQuestions(questionnaire.getId());
        delQuestions(questions);
        ansowerformMapper.deleteByExample(ansowerformExample);
        return questionnaireMapper.deleteByPrimaryKey(questionnaire.getId());
    }

    public List<Questions> queryQuestions(Integer qid) {
        QuestionsExample questionsExample = new QuestionsExample();
        QuestionsExample.Criteria criteria = questionsExample.createCriteria();
        criteria.andQuestionnaireidEqualTo(qid);
        return questionsMapper.selectByExample(questionsExample);
    }

    public int addQuestions(Questions questions, String[] option) {
        questions.setCreatetime(new Date());
        int row = questionsMapper.insertSelective(questions);
        if (option!=null&&option.length>0&&row!=0){
            for (String op: option){
                Options options = new Options();
                options.setVal(op);
                options.setQuestionid(questions.getId());
                optionsMapper.insertSelective(options);
            }
        }
        return row;
    }

    public int delQuestions(List<Questions> questions) {
        if (questions.size()>0){
            List<Long> qid = new ArrayList<>();
            for (Questions q:questions){
                qid.add(q.getId());
            }
            OptionsExample optionsExample = new OptionsExample();
            OptionsExample.Criteria criteria = optionsExample.createCriteria();
            criteria.andQuestionidIn(qid);
            List<Options> options = optionsMapper.selectByExample(optionsExample);
            delOptions(options);

            QuestionsExample questionsExample = new QuestionsExample();
            QuestionsExample.Criteria criteria1 = questionsExample.createCriteria();
            criteria1.andIdIn(qid);
            return questionsMapper.deleteByExample(questionsExample);
        }
        return 0;
    }

    public int updateQuestions(Questions questions) {
        return questionsMapper.updateByPrimaryKeySelective(questions);
    }

    public List<Options> queryOptions(Long qid) {
        OptionsExample optionsExample = new OptionsExample();
        OptionsExample.Criteria criteria = optionsExample.createCriteria();
        criteria.andQuestionidEqualTo(qid);
        return optionsMapper.selectByExample(optionsExample);
    }

    public void addOptions(Long questionid, String[] option) {
        for (String op: option){
            Options options = new Options();
            options.setVal(op);
            options.setQuestionid(questionid);
            optionsMapper.insertSelective(options);
        }
    }

    public int delOptions(List<Options> options) {
        if (options.size()>0){
            List<Long> ids = new ArrayList<>();
            for(Options op : options){
                ids.add(op.getId());
            }
            OptionsExample optionsExample = new OptionsExample();
            OptionsExample.Criteria criteria = optionsExample.createCriteria();
            criteria.andIdIn(ids);
            AnsowerExample ansowerExample = new AnsowerExample();
            AnsowerExample.Criteria criteria1 = ansowerExample.createCriteria();
            criteria1.andOptionidIn(ids);
            ansowerMapper.deleteByExample(ansowerExample);
            return optionsMapper.deleteByExample(optionsExample);
        }
        return 0;
    }

    public int updateOptions(Options options) {
        return optionsMapper.updateByPrimaryKeySelective(options);
    }
}
