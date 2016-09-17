package com.zhoukewei.nlp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.zhoukewei.nlp.eneity.User;
import com.zhoukewei.nlp.util.JDBCTools;

@Service
public class UserServiceImpl implements UserService{

//	private Map<Long,User> users=new HashMap<Long,User>();//user�б�
//	private AtomicLong generator=new AtomicLong();
	private User user;
	private JDBCTools jdbc;
	public UserServiceImpl(){
		jdbc=new JDBCTools();
	}
	public User add(User user) {
		this.user=user;
		
		return null;
	}

	public User queryUser(User userText) {
		User user = new User();
		String sql="select * from user_table where email=? and password=?";
		
		//�������ݿ� �Ƿ����
		List<List<String>> lists=jdbc.queryList(sql,new String[]{userText.getEmail(),userText.getPassword()});//sql���
		//��user��ֵ
		if(lists.size()==0)//�ж� �Ƿ�����˻� ��Ϊ0 ����û�� �˻�
			return null;
		List<String> list=lists.get(0);	
			
		user.setUserid(Integer.valueOf(list.get(0)).intValue());//��ֵ userid
		user.setEmail(list.get(1));//��ֵ email
		user.setUsername(list.get(2));//��ֵ username
		user.setPassword(list.get(3));//��ֵ password
		user.setFullname(list.get(4));//��ֵ fullname
		return user;
	}

}