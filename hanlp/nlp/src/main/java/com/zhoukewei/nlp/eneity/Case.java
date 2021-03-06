package com.zhoukewei.nlp.eneity;

import java.util.ArrayList;
import java.util.List;

public class Case {
	private long case_id;//病例 id
	private String question_type;//问题分类
	private String question_time;//回答日期
	private String question_title;//问题标题
	private String question_desc;//问题描述
	private String question_help;//寻求帮助
	private List<Answer> answers=new ArrayList<Answer>();//回答id
	
	public Case(){};
	
	public Case(long case_id, String question_type, String question_time, String question_title, String question_desc,
			String question_help, List<Answer> answers) {
		super();
		this.case_id = case_id;
		this.question_type = question_type;
		this.question_time = question_time;
		this.question_title = question_title;
		this.question_desc = question_desc;
		this.question_help = question_help;
		this.answers = answers;
	}
	
	public long getCase_id() {
		return case_id;
	}
	public void setCase_id(long case_id) {
		this.case_id = case_id;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	
	public String getQuestion_time() {
		return question_time;
	}
	public void setQuestion_time(String question_time) {
		this.question_time = question_time;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getQuestion_desc() {
		return question_desc;
	}
	public void setQuestion_desc(String question_desc) {
		this.question_desc = question_desc;
	}
	public String getQuestion_help() {
		return question_help;
	}
	public void setQuestion_help(String question_help) {
		this.question_help = question_help;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public void setAnswers(Answer answer){
		answers.add(answer);
	}
}
