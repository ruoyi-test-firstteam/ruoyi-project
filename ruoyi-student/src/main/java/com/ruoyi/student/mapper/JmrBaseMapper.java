package com.ruoyi.student.mapper;

import com.ruoyi.student.domain.JmrBase;

import java.util.List;

/**
 * 存储匹配好的岗位信息（面向学生端）的依赖数据Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-30
 */
public interface JmrBaseMapper 
{
    /**
     * 查询存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBId 存储匹配好的岗位信息（面向学生端）的依赖数据ID
     * @return 存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    public JmrBase selectJmrBaseById(Integer jmrBId);

    /**
     * 查询存储匹配好的岗位信息（面向学生端）的依赖数据列表
     * 
     * @param jmrBase 存储匹配好的岗位信息（面向学生端）的依赖数据
     * @return 存储匹配好的岗位信息（面向学生端）的依赖数据集合
     */
    public List<JmrBase> selectJmrBaseList(JmrBase jmrBase);

    /**
     * 新增存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBase 存储匹配好的岗位信息（面向学生端）的依赖数据
     * @return 结果
     */
    public int insertJmrBase(JmrBase jmrBase);

}
