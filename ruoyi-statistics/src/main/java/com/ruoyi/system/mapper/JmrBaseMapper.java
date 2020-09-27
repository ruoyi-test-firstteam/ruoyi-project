package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.JmrBase;

/**
 * 存储匹配好的岗位信息（面向学生端）的依赖数据Mapper接口
 * 
 * @author wby
 * @date 2020-09-27
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

    /**
     * 修改存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBase 存储匹配好的岗位信息（面向学生端）的依赖数据
     * @return 结果
     */
    public int updateJmrBase(JmrBase jmrBase);

    /**
     * 删除存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBId 存储匹配好的岗位信息（面向学生端）的依赖数据ID
     * @return 结果
     */
    public int deleteJmrBaseById(Integer jmrBId);

    /**
     * 批量删除存储匹配好的岗位信息（面向学生端）的依赖数据
     * 
     * @param jmrBIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmrBaseByIds(String[] jmrBIds);
}
