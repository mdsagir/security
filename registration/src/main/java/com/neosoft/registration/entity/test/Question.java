package com.neosoft.registration.entity.test;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String questionName;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "questionior_id")
	private Questionior questionior;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Questionior getQuestionior() {
		return questionior;
	}

	public void setQuestionior(Questionior questionior) {
		this.questionior = questionior;
	}
	
	
}
