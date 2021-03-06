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

//	private Map<Long,User> users=new HashMap<Long,User>();//user列表
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
		
		//访问数据库 是否存在
		List<List<String>> lists=jdbc.queryList(sql,new String[]{userText.getEmail(),userText.getPassword()});//sql语句
		//改user赋值
		if(lists.size()==0)//判断 是否存在账户 列为0 表明没有 账户
			return null;
		List<String> list=lists.get(0);	
			
		user.setUserid(Integer.valueOf(list.get(0)).intValue());//赋值 userid
		user.setEmail(list.get(1));//赋值 email
		user.setUsername(list.get(2));//赋值 username
		user.setPassword(list.get(3));//赋值 password
		user.setFullname(list.get(4));//赋值 fullname
		return user;
	}

}
