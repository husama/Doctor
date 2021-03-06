package com.zhoukewei.nlp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoukewei.nlp.eneity.User;
import com.zhoukewei.nlp.service.SerchService;
import com.zhoukewei.nlp.service.UserService;

@Controller
public class HomeController{//首页控制器  控制登录和注册

	@Autowired
	UserService userService;//用户
	//andriod
	/*
	@RequestMapping("/login。json")//登陆
	@ResponseBody
	public String Alogin(@RequestBody User userText,Model model){
		User user=userService.queryUser(userText);//根据email password 确定是否存在账户
		System.out.println("email"+userText.getEmail());
		if(user==null){
			System.out.println("error");
			return "error";
		}
		System.out.println("succeed");
		return "search";
	}
	*/
	//web
	
	@RequestMapping("/home")
	public String showHomePage(){
		System.out.println("111");
		return "Login";
	}
	/*
	 * @ResponseBody  
    public void saveUser(@RequestBody List<User> users) { 
         userService.batchSave(users); 
    } 
	 */
	@RequestMapping("/login.action")//登陆
	public String login(User userText,Model model){
		User user=userService.queryUser(userText);//根据email password 确定是否存在账户
		System.out.println("email"+userText.getEmail());
		if(user==null)
			return "error";
		return "search";
	}
	
	@RequestMapping("/register.action")//注册
	public String register(User user,Model model){
		model.addAttribute("user",user);
		System.out.println("email"+user.getEmail());
		System.out.println("password"+user.getPassword());
		return "search";
	}
/*	
	@RequestMapping(value="/login",method=RequestMethod.POST)//登陆
	public String login(@Valid User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "users";
		}
		return "redirect:/"+user.getUsername();
	}
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public String showSucceed(@PathVariable String username,Model model){
		return "succeed";
	}
*/
	/*
	@RequestMapping(value="/showRegisterForm",method=RequestMethod.GET)
	public String showRegisterForm(){
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)//注册
	public String register(@Valid User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "users";
		}
		return "redirect:/"+user.getUsername();
	}*/
}
