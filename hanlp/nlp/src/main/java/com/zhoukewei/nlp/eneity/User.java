package com.zhoukewei.nlp.eneity;

//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;


public class User {
	private long userid;
	
//	@Pattern(regexp="[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}",message="�����ʽ����ȷ")
	private String email;
	
//	@Size(min=3,max=20,message="�û�����������3���ַ�")
//	@Pattern(regexp="^[a-zA-Z0-9]+$",message="�û��������пո�")
	private String username;
	
//	@Size(min=6,max=20,message="��������6���ַ�")
	private String password;
	
//	@Size(min=3,max=50,message="����������3-50�ַ�֮��")
	private String fullname;
	


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

}
