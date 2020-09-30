package com.ruoyi.company.service;

import java.util.List;
import com.ruoyi.company.domain.JmrJob;

/**
 * 企业岗位管理3.0Service接口
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
public interface IJmrJobService 
{
    /**
     * 查询企业岗位管理3.0
     * 
     * @param jId 企业岗位管理3.0ID
     * @return 企业岗位管理3.0
     */
    public JmrJob selectJmrJobById(Integer jId);

    /**
     * 查询企业岗位管理3.0列表
     * 
     * @param jmrJob 企业岗位管理3.0
     * @return 企业岗位管理3.0集合
     */
    public List<JmrJob> selectJmrJobList(JmrJob jmrJob);

    /**
     * 新增企业岗位管理3.0
     * 
     * @param jmrJob 企业岗位管理3.0
     * @return 结果
     */
    public int insertJmrJob(JmrJob jmrJob);

    /**
     * 修改企业岗位管理3.0
     * 
     * @param jmrJob 企业岗位管理3.0
     * @return 结果
     */
    public int updateJmrJob(JmrJob jmrJob);

    /**
     * 批量删除企业岗位管理3.0
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmrJobByIds(String ids);

    /**
     * 删除企业岗位管理3.0信息
     * 
     * @param jId 企业岗位管理3.0ID
     * @return 结果
     */
    public int deleteJmrJobById(Integer jId);
}
