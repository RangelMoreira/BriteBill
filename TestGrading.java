package com.britebill.peerreview;

import com.britebill.peerreview.thirdparty.Answer;
import com.britebill.peerreview.thirdparty.AnswerValidation;
import com.britebill.peerreview.thirdparty.Test;
import com.britebill.peerreview.thirdparty.TestRepo;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import java.io.IOException;

@SuppressWarnings("Duplicates")
@Service
public class TestGrading {

    @Autowired
    private AnswerValidation answerValidation;

    private Test test;

    public int ProcessTest(int id){
        test = TestRepo.getTest(id);
        int grade = check(test.getAsnwers());

        for(int i = 0 ; i < answers.size(); i++){
            grade = answerValidation.grade(answers.get(i));
        }
        if(grade > 8){
            return 2;
        }
        if(grade > 5){
            return 1;
        }
        test.setStatus("Failed");
        return 0;
    }
}