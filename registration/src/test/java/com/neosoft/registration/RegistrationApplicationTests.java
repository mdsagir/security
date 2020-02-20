package com.neosoft.registration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.registration.entity.test.Question;
import com.neosoft.registration.entity.test.QuestioniorRepo;
import com.neosoft.registration.entity.test.Questionior;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationApplicationTests {

	@Autowired
	private QuestioniorRepo questionRepo;
	
	@Test
	@Transactional
	public void contextLoads() {
	
		List<Question> list=new ArrayList<>();
		
		Questionior questionior=new Questionior();
		Question question1=new Question();
		question1.setQuestionName("question1");
		question1.setQuestionior(questionior);
		
		Question question2=new Question();
		question2.setQuestionName("question1");
		question2.setQuestionior(questionior);
		
		list.add(question1);
		list.add(question2);
		
		
		questionior.setQuestionNior("Questionior1");
		questionior.setQuestions(list);
		
		questionRepo.save(questionior);
		
		System.out.println(questionRepo);
	}

}
