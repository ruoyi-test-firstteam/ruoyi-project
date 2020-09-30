package com.ruoyi.company.service.impl;

import com.ruoyi.company.domain.JmrBase;
import com.ruoyi.company.mapper.JmrBaseMapper;
import com.ruoyi.company.service.IJmrBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IJmrBaseServiceImpl implements IJmrBaseService {

    @Autowired
    private JmrBaseMapper studentMatchResultMapper;

    //存储匹配值信息
    public void save(JmrBase studentMatchResult){
        studentMatchResultMapper.save(studentMatchResult);
    }
}
