package com.ruoyi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.company.mapper.JmrJobMapper;
import com.ruoyi.company.domain.JmrJob;
import com.ruoyi.company.service.IJmrJobService;
import com.ruoyi.common.core.text.Convert;

/**
 * 存储企业保存的岗位信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-27
 */
@Service
public class JmrJobServiceImpl implements IJmrJobService 
{
    @Autowired
    private JmrJobMapper jmrJobMapper;

    /**
     * 查询存储企业保存的岗位信息
     * 
     * @param jId 存储企业保存的岗位信息ID
     * @return 存储企业保存的岗位信息
     */
    @Override
    public JmrJob selectJmrJobById(Integer jId)
    {
        return jmrJobMapper.selectJmrJobById(jId);
    }

    /**
     * 查询存储企业保存的岗位信息列表
     * 
     * @param jmrJob 存储企业保存的岗位信息
     * @return 存储企业保存的岗位信息
     */
    @Override
    public List<JmrJob> selectJmrJobList(JmrJob jmrJob)
    {
        return jmrJobMapper.selectJmrJobList(jmrJob);
    }

    /**
     * 新增存储企业保存的岗位信息
     * 
     * @param jmrJob 存储企业保存的岗位信息
     * @return 结果
     */
    @Override
    public int insertJmrJob(JmrJob jmrJob)
    {
        jmrJob.setjPoId(1);
        return jmrJobMapper.insertJmrJob(jmrJob);
    }

    /**
     * 修改存储企业保存的岗位信息
     * 
     * @param jmrJob 存储企业保存的岗位信息
     * @return 结果
     */
    @Override
    public int updateJmrJob(JmrJob jmrJob)
    {
        return jmrJobMapper.updateJmrJob(jmrJob);
    }

    /**
     * 删除存储企业保存的岗位信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmrJobByIds(String ids)
    {
        return jmrJobMapper.deleteJmrJobByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除存储企业保存的岗位信息信息
     * 
     * @param jId 存储企业保存的岗位信息ID
     * @return 结果
     */
    @Override
    public int deleteJmrJobById(Integer jId)
    {
        return jmrJobMapper.deleteJmrJobById(jId);
    }
}
