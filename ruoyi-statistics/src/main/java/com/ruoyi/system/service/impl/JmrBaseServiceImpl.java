package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.JmrBaseMapper;
import com.ruoyi.system.domain.JmrBase;
import com.ruoyi.system.service.IJmrBaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 存储匹配好的岗位信息（面向学生端）的依赖数据Service业务层处理
 * 
 * @author wby
 * @date 2020-09-27
 */
@Service
public class JmrBaseServiceImpl implements IJmrBaseService 
{
    @Autowired
    private JmrBaseMapper jmrBaseMapper;

    /**
     * 查询存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBId 存储匹配好的岗位信息（面向学生端）的依赖数据ID
     * @return 存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    @Override
    public JmrBase selectJmrBaseById(Integer jmrBId)
    {
        return jmrBaseMapper.selectJmrBaseById(jmrBId);
    }

    /**
     * 查询存储匹配好的岗位信息（面向学生端）的依赖数据列表
     * 
     * @param jmrBase 存储匹配好的岗位信息（面向学生端）的依赖数据
     * @return 存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    @Override
    public List<JmrBase> selectJmrBaseList(JmrBase jmrBase)
    {
        return jmrBaseMapper.selectJmrBaseList(jmrBase);
    }

    /**
     * 新增存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBase 存储匹配好的岗位信息（面向学生端）的依赖数据
     * @return 结果
     */
    @Override
    public int insertJmrBase(JmrBase jmrBase)
    {
        return jmrBaseMapper.insertJmrBase(jmrBase);
    }

    /**
     * 修改存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBase 存储匹配好的岗位信息（面向学生端）的依赖数据
     * @return 结果
     */
    @Override
    public int updateJmrBase(JmrBase jmrBase)
    {
        return jmrBaseMapper.updateJmrBase(jmrBase);
    }

    /**
     * 删除存储匹配好的岗位信息（面向学生端）的依赖数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmrBaseByIds(String ids)
    {
        return jmrBaseMapper.deleteJmrBaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除存储匹配好的岗位信息（面向学生端）的依赖数据信息
     * 
     * @param jmrBId 存储匹配好的岗位信息（面向学生端）的依赖数据ID
     * @return 结果
     */
    @Override
    public int deleteJmrBaseById(Integer jmrBId)
    {
        return jmrBaseMapper.deleteJmrBaseById(jmrBId);
    }
}
