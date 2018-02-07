package com.nationsky.busi.dao;

import java.util.List;
import java.util.Map;

public interface NewsDao {

    public List<Map<String,Object>> listPolicyAndLaws(Map<String,Object> param);

    public Map<String,Object> getPolicyAndLawsById(String lawId);
}
