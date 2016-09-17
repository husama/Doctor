package com.zhoukewei.nlp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhoukewei.nlp.eneity.Answer;
import com.zhoukewei.nlp.eneity.Case;
import com.zhoukewei.nlp.util.JDBCTools;

@Service
public class SearchServiceImpl implements SerchService{
	private String keyWord; //�ؼ���
	private List<Case> cases=new ArrayList<Case>();//����
	private JDBCTools jdbc;
	
	public SearchServiceImpl(){
		jdbc=new JDBCTools();
	}
	public List<Case> getSearchResult(String keyWord){
	//	List<Long> caseId=new ArrayList<Long>();//�����id
		
		//��Ҫ���*******************************
		//����
		String sql="select case_id,question_id,question_type,question_time,question_title,question_desc,question_help,"+
				"answer_id,doctor_id,bool_adopt,answer_time,answer_analysis,answer_suggest"+
				" from case_table natural join question_table natural join answer_table";
		//�������ݿ� �Ƿ����
		List<List<String>> lists=jdbc.queryList(sql);//sql���
	
		//����
		
		//*******************************
		
		//��case��ֵ
		if(lists.size()==0)//�ж� �Ƿ�����˻� ��Ϊ0 ����û�� �˻�
			return null;
		List<String> list;
		
		for(int i=0, j=0;i<lists.size();j++){
			Case casetemp=new Case();//�ȴ� ���ܻ�й¶  �Ժ��ٸ�
			Answer answertemp=new Answer();
			long idtemp;//���case_idֵ 
			list=lists.get(i);	
			idtemp=Integer.valueOf(lists.get(i).get(1)).intValue();//���case_idֵ 
			
			//��ֵcase
			casetemp.setCase_id(idtemp);//��ֵcaseid
			casetemp.setQuestion_type(list.get(2));//��ֵ��������
			casetemp.setQuestion_time(list.get(3));//����ʱ��
			casetemp.setQuestion_title(list.get(4));//��ֵ�������
			casetemp.setQuestion_desc(list.get(5));//��ֵ��������
			casetemp.setQuestion_help(list.get(6));//��ֵ�������
	//		casetemp.setAnswers((List<Answer>)null);
			System.out.println("size"+lists.size());
			cases.add(casetemp);
			//��ֵanswer
			int k=i;
			while(i <lists.size()&&Integer.valueOf(lists.get(i).get(1)).intValue()==idtemp){
				System.out.println("a��b:"+Integer.valueOf(lists.get(i).get(1)).intValue()+"  "+idtemp);
				System.out.println("i��k:"+i+"  "+k);
				answertemp.setAnswer_id(Integer.valueOf(list.get(7)).intValue());//��ֵanswerid
				answertemp.setDoctor_id(Integer.valueOf(list.get(8)).intValue());//��ֵҽ��id
				answertemp.setBool_adopt(Integer.valueOf(list.get(9)).intValue());
				answertemp.setAnswer_time(list.get(10));//��ֵ�ش�ʱ��
				answertemp.setAnswer_analysis(list.get(11));//��ֵ�ش����
				answertemp.setAnswer_suggest(list.get(12));//��ֵ�ش���
				cases.get(j).setAnswers(answertemp);
				i++;
			}
			if(k==i)
				i++;
		}
		return cases;
	}
}