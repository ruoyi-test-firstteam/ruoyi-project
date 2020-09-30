package com.ruoyi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.company.mapper.JmrStudentMatchResultMapper;
import com.ruoyi.company.domain.JmrStudentMatchResult;
import com.ruoyi.company.service.IJmrStudentMatchResultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 存储匹配好的岗位信息（面向学生端)Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-30
 */
@Service
public class JmrStudentMatchResultServiceImpl implements IJmrStudentMatchResultService 
{
    @Autowired
    private JmrStudentMatchResultMapper jmrStudentMatchResultMapper;

    /**
     * 查询存储匹配好的岗位信息（面向学生端)
     * 
     * @param smrId 存储匹配好的岗位信息（面向学生端)ID
     * @return 存储匹配好的岗位信息（面向学生端)
     */
    @Override
    public JmrStudentMatchResult selectJmrStudentMatchResultById(Long smrId)
    {
        return jmrStudentMatchResultMapper.selectJmrStudentMatchResultById(smrId);
    }

    /**
     * 查询存储匹配好的岗位信息（面向学生端)列表
     * 
     * @param jmrStudentMatchResult 存储匹配好的岗位信息（面向学生端)
     * @return 存储匹配好的岗位信息（面向学生端)
     */
    @Override
    public List<JmrStudentMatchResult> selectJmrStudentMatchResultList(JmrStudentMatchResult jmrStudentMatchResult)
    {
        return jmrStudentMatchResultMapper.selectJmrStudentMatchResultList(jmrStudentMatchResult);
    }

    /**
     * 新增存储匹配好的岗位信息（面向学生端)
     * 
     * @param jmrStudentMatchResult 存储匹配好的岗位信息（面向学生端)
     * @return 结果
     */
    @Override
    public int insertJmrStudentMatchResult(JmrStudentMatchResult jmrStudentMatchResult)
    {
        return jmrStudentMatchResultMapper.insertJmrStudentMatchResult(jmrStudentMatchResult);
    }

    /**
     * 修改存储匹配好的岗位信息（面向学生端)
     * 
     * @param jmrStudentMatchResult 存储匹配好的岗位信息（面向学生端)
     * @return 结果
     */
    @Override
    public int updateJmrStudentMatchResult(JmrStudentMatchResult jmrStudentMatchResult)
    {
        return jmrStudentMatchResultMapper.updateJmrStudentMatchResult(jmrStudentMatchResult);
    }

    /**
     * 删除存储匹配好的岗位信息（面向学生端)对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmrStudentMatchResultByIds(String ids)
    {
        return jmrStudentMatchResultMapper.deleteJmrStudentMatchResultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除存储匹配好的岗位信息（面向学生端)信息
     * 
     * @param smrId 存储匹配好的岗位信息（面向学生端)ID
     * @return 结果
     */
    @Override
    public int deleteJmrStudentMatchResultById(Long smrId)
    {
        return jmrStudentMatchResultMapper.deleteJmrStudentMatchResultById(smrId);
    }
}
