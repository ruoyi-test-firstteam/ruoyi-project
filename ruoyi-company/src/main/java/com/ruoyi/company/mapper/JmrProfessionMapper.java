package com.ruoyi.company.mapper;

import com.ruoyi.company.domain.JmrProfession;

import java.util.List;
//专业信息dao层
public interface JmrProfessionMapper {

    //查询专业信息列表
    public List<JmrProfession> selectJmrProfessionList();
}
