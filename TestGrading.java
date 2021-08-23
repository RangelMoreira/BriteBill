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
      return passfail(grade);
    }

    private int check(List<Answer> answers){
      int grade;
      for(int i = 0 ; i < answers.size(); i++){
        grade = answerValidation.grade(answers.get(i));
      }
      if(grade < 5){
        test.setStatus("Failed");
      }
      return grade;
    }

    private int passfail(int grade){
      if(grade > 8){
        return 2;
      }
      if(grade > 5){
        return 1;
      }
      return 0;
    }
}