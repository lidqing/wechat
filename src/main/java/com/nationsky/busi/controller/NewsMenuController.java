package com.nationsky.busi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nationsky.busi.service.NewsService;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 河长制菜单功能
 * @author LDQ
 *
 */
@Controller
@RequestMapping("/news")
public class NewsMenuController {
	
	@Autowired
	private NewsService newsService;
	
	/**
	 * 政策法规
	 * @return
	 */
	@RequestMapping("/laws")
	public String lawsList(Model model){
		model.addAttribute("title", "政策法规");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

		/*
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("name", "政策法规111111111111111111111111111222222233");
		data.put("url", "https://www.baidu.com");
		data.put("date", "2018-02-12");
		list.add(data);
		list.add(data);
		list.add(data);
		list.add(data);
		list.add(data);
		System.out.println("hahahhahahahahahh12");
		//model.addAllAttributes(list);
		model.addAttribute("list", list);
		*/
		Map<String,Object> map = new HashMap<String,Object>();
		list = newsService.listPolicyAndLaws(map);
		model.addAttribute("list",list);
		return "t_comb_list";
	}
	
	/**
	 * 河长职责
	 * @return
	 */
	@RequestMapping("/duty")
	public String dutyList(){
		return "river_admin_duty";
	}
	
	/**
	 * 河长动态
	 * @return
	 */
	@RequestMapping("/dynamic")
	public String dynamicList(){
		return "gt_comblist";
	}

	@RequestMapping("/article")
	public String article(@RequestParam("articleId") String articleId){
		System.out.println("=======articleId======"+articleId);

		return "article";
	}
	
}
