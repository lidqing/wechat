package com.nationsky.busi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nationsky.base.config.ApplicationConfig;
import com.nationsky.base.config.WxMpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nationsky.busi.service.NewsService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 河长制菜单功能
 *
 * @author LDQ
 */
@Controller
@RequestMapping("/news")
public class NewsMenuController {
    //分页大小
    private static final int size = 10;

    @Autowired
    private NewsService newsService;

    /**
     * 政策法规
     *
     * @return
     */
    @RequestMapping("/laws")
    public String lawsList(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
        model.addAttribute("title", "政策法规");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (page - 1) * size);
        map.put("size", size);
        list = newsService.listPolicyAndLaws(map);
        model.addAttribute("list", list);
        return "t_comb_list";
    }

    /**
     * 异步获取政策法规
     * */
    @RequestMapping("/getLaws")
    public @ResponseBody List<Map<String,Object>> getLawsAjax(
            @RequestParam(name = "page", defaultValue = "1") int page){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (page - 1) * size);
        map.put("size", size);
        List<Map<String,Object>> list = newsService.listPolicyAndLaws(map);
        return list;
    }

    /**
     * 河长职责
     *
     * @return
     */
    @RequestMapping("/duty")
    public String dutyList() {
        return "river_admin_duty";
    }

    /**
     * 河长动态
     *
     * @return
     */
    @RequestMapping("/dynamic")
    public String dynamicList() {
        return "gt_comblist";
    }

    @RequestMapping("/article")
    public String article(@RequestParam("articleId") String articleId) {
        System.out.println("=======articleId======" + articleId);

        return "article";
    }



}
