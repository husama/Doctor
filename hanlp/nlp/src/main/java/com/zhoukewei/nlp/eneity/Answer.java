package com.zhoukewei.nlp.eneity;

public class Answer {
	private long answer_id;//回答 id
	private int doctor_id;//医生id
	private int bool_adopt;//是否采纳
	private String answer_time;//回答日期
	private String answer_analysis;//回答分析
	private String answer_suggest;//回答建议
	public long getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(long answer_id) {
		this.answer_id = answer_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int isBool_adopt() {
		return bool_adopt;
	}
	public void setBool_adopt(int bool_adopt) {
		this.bool_adopt = bool_adopt;
	}
	
	public String getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(String answer_time) {
		this.answer_time = answer_time;
	}
	public String getAnswer_analysis() {
		return answer_analysis;
	}
	public void setAnswer_analysis(String answer_analysis) {
		this.answer_analysis = answer_analysis;
	}
	public String getAnswer_suggest() {
		return answer_suggest;
	}
	public void setAnswer_suggest(String answer_suggest) {
		this.answer_suggest = answer_suggest;
	}
	
	
}
