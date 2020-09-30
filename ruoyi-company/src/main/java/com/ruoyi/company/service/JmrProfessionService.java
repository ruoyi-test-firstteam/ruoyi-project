package com.ruoyi.company.service;

import com.ruoyi.company.domain.JmrProfession;

import java.util.List;

//专业信息服务层
public interface JmrProfessionService {

    //查询专业信息列表
    public List<JmrProfession> selectJmrProfessionList();

}
