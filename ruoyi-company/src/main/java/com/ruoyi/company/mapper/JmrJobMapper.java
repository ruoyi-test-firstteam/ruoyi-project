package com.ruoyi.company.mapper;

import java.util.List;
import com.ruoyi.company.domain.JmrJob;

/**
 * 存储企业保存的岗位信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-27
 */
public interface JmrJobMapper 
{
    /**
     * 查询存储企业保存的岗位信息
     * 
     * @param jId 存储企业保存的岗位信息ID
     * @return 存储企业保存的岗位信息
     */
    public JmrJob selectJmrJobById(Integer jId);

    /**
     * 查询存储企业保存的岗位信息列表
     * 
     * @param jmrJob 存储企业保存的岗位信息
     * @return 存储企业保存的岗位信息集合
     */
    public List<JmrJob> selectJmrJobList(JmrJob jmrJob);

    /**
     * 新增存储企业保存的岗位信息
     * 
     * @param jmrJob 存储企业保存的岗位信息
     * @return 结果
     */
    public int insertJmrJob(JmrJob jmrJob);

    /**
     * 修改存储企业保存的岗位信息
     * 
     * @param jmrJob 存储企业保存的岗位信息
     * @return 结果
     */
    public int updateJmrJob(JmrJob jmrJob);

    /**
     * 删除存储企业保存的岗位信息
     * 
     * @param jId 存储企业保存的岗位信息ID
     * @return 结果
     */
    public int deleteJmrJobById(Integer jId);

    /**
     * 批量删除存储企业保存的岗位信息
     * 
     * @param jIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmrJobByIds(String[] jIds);
}
