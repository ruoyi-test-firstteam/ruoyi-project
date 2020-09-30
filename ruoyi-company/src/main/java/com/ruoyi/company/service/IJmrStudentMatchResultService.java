package com.ruoyi.company.service;

import java.util.List;
import com.ruoyi.company.domain.JmrStudentMatchResult;

/**
 * 存储匹配好的岗位信息（面向学生端)Service接口
 * 
 * @author ruoyi
 * @date 2020-09-30
 */
public interface IJmrStudentMatchResultService 
{
    /**
     * 查询存储匹配好的岗位信息（面向学生端)
     * 
     * @param smrId 存储匹配好的岗位信息（面向学生端)ID
     * @return 存储匹配好的岗位信息（面向学生端)
     */
    public JmrStudentMatchResult selectJmrStudentMatchResultById(Long smrId);

    /**
     * 查询存储匹配好的岗位信息（面向学生端)列表
     * 
     * @param jmrStudentMatchResult 存储匹配好的岗位信息（面向学生端)
     * @return 存储匹配好的岗位信息（面向学生端)集合
     */
    public List<JmrStudentMatchResult> selectJmrStudentMatchResultList(JmrStudentMatchResult jmrStudentMatchResult);

    /**
     * 新增存储匹配好的岗位信息（面向学生端)
     * 
     * @param jmrStudentMatchResult 存储匹配好的岗位信息（面向学生端)
     * @return 结果
     */
    public int insertJmrStudentMatchResult(JmrStudentMatchResult jmrStudentMatchResult);

    /**
     * 修改存储匹配好的岗位信息（面向学生端)
     * 
     * @param jmrStudentMatchResult 存储匹配好的岗位信息（面向学生端)
     * @return 结果
     */
    public int updateJmrStudentMatchResult(JmrStudentMatchResult jmrStudentMatchResult);

    /**
     * 批量删除存储匹配好的岗位信息（面向学生端)
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmrStudentMatchResultByIds(String ids);

    /**
     * 删除存储匹配好的岗位信息（面向学生端)信息
     * 
     * @param smrId 存储匹配好的岗位信息（面向学生端)ID
     * @return 结果
     */
    public int deleteJmrStudentMatchResultById(Long smrId);
}
