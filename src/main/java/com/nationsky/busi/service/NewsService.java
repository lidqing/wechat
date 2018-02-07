package com.nationsky.busi.service;

import com.nationsky.busi.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("newsService")
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public List<Map<String,Object>> listPolicyAndLaws(Map<String,Object> param){
        return newsDao.listPolicyAndLaws(param);
    }

    public Map<String,Object> getPolicyAndLawsById(String lawId){
        return getPolicyAndLawsById(lawId);
    }
	
}
