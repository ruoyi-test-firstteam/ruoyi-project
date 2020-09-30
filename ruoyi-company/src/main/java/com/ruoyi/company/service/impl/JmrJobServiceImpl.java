package com.ruoyi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.company.mapper.JmrJobMapper;
import com.ruoyi.company.domain.JmrJob;
import com.ruoyi.company.service.IJmrJobService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业岗位管理3.0Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
@Service
public class JmrJobServiceImpl implements IJmrJobService 
{
    @Autowired
    private JmrJobMapper jmrJobMapper;

    /**
     * 查询企业岗位管理3.0
     * 
     * @param jId 企业岗位管理3.0ID
     * @return 企业岗位管理3.0
     */
    @Override
    public JmrJob selectJmrJobById(Integer jId)
    {
        return jmrJobMapper.selectJmrJobById(jId);
    }

    /**
     * 查询企业岗位管理3.0列表
     * 
     * @param jmrJob 企业岗位管理3.0
     * @return 企业岗位管理3.0
     */
    @Override
    public List<JmrJob> selectJmrJobList(JmrJob jmrJob)
    {
        return jmrJobMapper.selectJmrJobList(jmrJob);
    }

    /**
     * 新增企业岗位管理3.0
     * 
     * @param jmrJob 企业岗位管理3.0
     * @return 结果
     */
    @Override
    public int insertJmrJob(JmrJob jmrJob)
    {
        return jmrJobMapper.insertJmrJob(jmrJob);
    }

    /**
     * 修改企业岗位管理3.0
     * 
     * @param jmrJob 企业岗位管理3.0
     * @return 结果
     */
    @Override
    public int updateJmrJob(JmrJob jmrJob)
    {
        return jmrJobMapper.updateJmrJob(jmrJob);
    }

    /**
     * 删除企业岗位管理3.0对象
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
     * 删除企业岗位管理3.0信息
     * 
     * @param jId 企业岗位管理3.0ID
     * @return 结果
     */
    @Override
    public int deleteJmrJobById(Integer jId)
    {
        return jmrJobMapper.deleteJmrJobById(jId);
    }
}
