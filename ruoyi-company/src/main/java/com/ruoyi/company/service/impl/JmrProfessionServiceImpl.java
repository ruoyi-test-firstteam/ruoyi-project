package com.ruoyi.company.service.impl;

import com.ruoyi.company.domain.JmrProfession;
import com.ruoyi.company.mapper.JmrProfessionMapper;
import com.ruoyi.company.service.JmrProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//专业信息服务层

@Service("JmrProfessionServiceImpl")
public class JmrProfessionServiceImpl implements JmrProfessionService {
    @Autowired
    private JmrProfessionMapper jmrProfessionMapper;

    @Override
    public List<JmrProfession> selectJmrProfessionList() {
        return jmrProfessionMapper.selectJmrProfessionList();
    }
}
