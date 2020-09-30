package com.ruoyi.company.mapper;

import java.util.List;
import com.ruoyi.company.domain.JmrStudent;

/**
 * 存储学生信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-30
 */
public interface JmrStudentMapper 
{
    /**
     * 查询存储学生信息
     * 
     * @param sId 存储学生信息ID
     * @return 存储学生信息
     */
    public JmrStudent selectJmrStudentById(Long sId);

    /**
     * 查询存储学生信息列表
     * 
     * @param jmrStudent 存储学生信息
     * @return 存储学生信息集合
     */
    public List<JmrStudent> selectJmrStudentList(JmrStudent jmrStudent);

    /**
     * 新增存储学生信息
     * 
     * @param jmrStudent 存储学生信息
     * @return 结果
     */
    public int insertJmrStudent(JmrStudent jmrStudent);

    /**
     * 修改存储学生信息
     * 
     * @param jmrStudent 存储学生信息
     * @return 结果
     */
    public int updateJmrStudent(JmrStudent jmrStudent);

    /**
     * 删除存储学生信息
     * 
     * @param sId 存储学生信息ID
     * @return 结果
     */
    public int deleteJmrStudentById(Long sId);

    /**
     * 批量删除存储学生信息
     * 
     * @param sIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmrStudentByIds(String[] sIds);
}
