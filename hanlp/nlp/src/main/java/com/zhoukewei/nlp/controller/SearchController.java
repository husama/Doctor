package com.zhoukewei.nlp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoukewei.nlp.eneity.Case;
import com.zhoukewei.nlp.eneity.Answer;
import com.zhoukewei.nlp.service.SerchService;

@Controller
public class SearchController {//搜索控制器
	
	@Autowired
	private SerchService serchService;
	
	@RequestMapping("/search_request")//查找  排序并返回处理结果
	public String search(String keyword,Model model){
		System.out.println(keyword);
		List<Case> cases=serchService.getSearchResult(keyword);
		function(cases);
		model.addAttribute("cases",cases);
		return "SearchResult";
	}
		
	@RequestMapping("/search_request/{case_id}")//返回点击页面
	public String returnCasePage(@PathVariable Long id,Model model){
		
		return "succeed";
	}
	
	private void function(List<Case> cases){
	
		System.out.println(cases.get(0).getCase_id());
		System.out.println(cases.get(0).getQuestion_desc());
		System.out.println(cases.get(0).getQuestion_help());
		System.out.println(cases.get(0).getQuestion_time());
		System.out.println(cases.get(0).getQuestion_title());
		System.out.println(cases.get(0).getQuestion_type());
		System.out.println(cases.get(0).getAnswers().get(1).getAnswer_suggest());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}

