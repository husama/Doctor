package com.zhoukewei.nlp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhoukewei.nlp.eneity.Answer;
import com.zhoukewei.nlp.eneity.Case;
import com.zhoukewei.nlp.util.JDBCTools;

@Service
public class SearchServiceImpl implements SerchService{
	private String keyWord; //关键词
	private List<Case> cases=new ArrayList<Case>();//病例
	private JDBCTools jdbc;
	
	public SearchServiceImpl(){
		jdbc=new JDBCTools();
	}
	public List<Case> getSearchResult(String keyWord){
	//	List<Long> caseId=new ArrayList<Long>();//结果的id
		
		//需要大改*******************************
		//查找
		String sql="select case_id,question_id,question_type,question_time,question_title,question_desc,question_help,"+
				"answer_id,doctor_id,bool_adopt,answer_time,answer_analysis,answer_suggest"+
				" from case_table natural join question_table natural join answer_table";
		//访问数据库 是否存在
		List<List<String>> lists=jdbc.queryList(sql);//sql语句
	
		//排序
		
		//*******************************
		
		//给case赋值
		if(lists.size()==0)//判断 是否存在账户 列为0 表明没有 账户
			return null;
		List<String> list;
		
		for(int i=0, j=0;i<lists.size();j++){
			Case casetemp=new Case();//內存 可能会泄露  以后再改
			Answer answertemp=new Answer();
			long idtemp;//获得case_id值 
			list=lists.get(i);	
			idtemp=Integer.valueOf(lists.get(i).get(1)).intValue();//获得case_id值 
			
			//赋值case
			casetemp.setCase_id(idtemp);//赋值caseid
			casetemp.setQuestion_type(list.get(2));//赋值问题类型
			casetemp.setQuestion_time(list.get(3));//问题时间
			casetemp.setQuestion_title(list.get(4));//赋值问题标题
			casetemp.setQuestion_desc(list.get(5));//赋值问题描述
			casetemp.setQuestion_help(list.get(6));//赋值问题帮助
	//		casetemp.setAnswers((List<Answer>)null);
			System.out.println("size"+lists.size());
			cases.add(casetemp);
			//赋值answer
			int k=i;
			while(i <lists.size()&&Integer.valueOf(lists.get(i).get(1)).intValue()==idtemp){
				System.out.println("a，b:"+Integer.valueOf(lists.get(i).get(1)).intValue()+"  "+idtemp);
				System.out.println("i，k:"+i+"  "+k);
				answertemp.setAnswer_id(Integer.valueOf(list.get(7)).intValue());//赋值answerid
				answertemp.setDoctor_id(Integer.valueOf(list.get(8)).intValue());//赋值医生id
				answertemp.setBool_adopt(Integer.valueOf(list.get(9)).intValue());
				answertemp.setAnswer_time(list.get(10));//赋值回答时间
				answertemp.setAnswer_analysis(list.get(11));//赋值回答分析
				answertemp.setAnswer_suggest(list.get(12));//赋值回答建议
				cases.get(j).setAnswers(answertemp);
				i++;
			}
			if(k==i)
				i++;
		}
		return cases;
	}
}
