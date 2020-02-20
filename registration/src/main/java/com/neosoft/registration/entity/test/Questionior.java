package com.neosoft.registration.entity.test;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questionior {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String questionNior;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionior",cascade=CascadeType.ALL)
	private List<Question> questions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionNior() {
		return questionNior;
	}

	public void setQuestionNior(String questionNior) {
		this.questionNior = questionNior;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
