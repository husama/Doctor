package com.zhoukewei.nlp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCTools {
	/**驱动*/
	private static final String driver="com.mysql.jdbc.Driver";
	/**连接信息*/
	private static final String url="jdbc:mysql://localhost:3306/";
	/**用户名*/
	private static final String userName="root";
	/**密码*/
	private static final String password="123456";
	/**数据库*/
	private static final String database="nlp_db";
	/**连接对象*/
	private Connection con;
	/**预编译对象*/
	private PreparedStatement ps;
	/**结果集*/
	private ResultSet rs;
	/**
	 * 构造方法
	 */
	public JDBCTools(){
		try {
			//1、找到软件的启动程序【加载驱动】
			Class.forName(driver);
			//2、填写链接信息【获取链接对象】
			con= DriverManager.getConnection(url+database,userName,password);
			//3、找到一个写sql的窗口【创建一个执行sql语句的对象】
			//ps= con.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行DML语句
	 * @author 
	 * @title: Update
	 * @date 2016年6月5日 上午10:39:00
	 * @param sql void
	 */
	public void Update(String sql,String[]param){
		try {
			ps=con.prepareStatement(sql);
			if (param!=null) {
				for (int i = 0; i < param.length; i++) {
					ps.setString(i+1, param[i]);
				}
			}
			ps.executeUpdate();
			//System.out.println("添加成功");
		} catch (SQLException e) {
			System.out.println("添加失败");
			e.printStackTrace();
		}
	}
	public void Update(String sql){
		Update(sql,null);
	}
	/**
	 * 执行DQL语句
	 * @author 
	 * @title: Query
	 * @date 2016年6月5日 上午10:39:06
	 * @param sql
	 * @return ResultSet
	 */
	public List<List<String>> queryList(String sql,String[]param){
		List<List<String>> tableList = new  ArrayList<List<String>>();
		try {
			ps=con.prepareStatement(sql);
			if (param!=null) {
				for (int i = 0; i < param.length; i++) {
					ps.setString(i+1, param[i]);
				}
			}
			rs = ps.executeQuery();
			//通过此对象获取sql语句中列的相关信息
			ResultSetMetaData rsmd= rs.getMetaData();
			//列的个数
			int columnCount =rsmd.getColumnCount();
			while (rs.next()) {
				List<String> row = new ArrayList<String>();
				//把数据库中当前行的每个列的信息放到row中
				for (int col = 1; col <=columnCount; col++) {
					row.add(rs.getString(col));
				}
				//把当前行数据放到表格中
				tableList.add(row);			
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}
	public List<List<String>> queryList(String sql){
		return queryList(sql,null);
	}
	public List<Map<String, String>> queryMap(String sql,String[]param){
		List<Map<String, String>> tableList = new  ArrayList<Map<String, String>>();
		try {
			ps=con.prepareStatement(sql);
			if (param!=null) {
				for (int i = 0; i < param.length; i++) {
					ps.setString(i+1, param[i]);
					
				}
			}
			rs = ps.executeQuery();
			//通过此对象获取sql语句中列的相关信息
			ResultSetMetaData rsmd= rs.getMetaData();
			//列的个数
			int columnCount =rsmd.getColumnCount();
			while (rs.next()) {
				Map<String,String> row = new HashMap<String, String>();
				//把数据库中当前行的每个列的信息放到row中
				for (int col = 1; col <=columnCount; col++) {
					row.put(rsmd.getColumnName(col).toLowerCase(), rs.getString(col));
				}
				//把当前行数据放到表格中
				tableList.add(row);			
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}
	public List<Map<String, String>> queryMap(String sql){
		return queryMap(sql,null);
	}
}
