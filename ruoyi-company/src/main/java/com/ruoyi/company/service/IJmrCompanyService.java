package com.ruoyi.company.service;

import java.util.List;
import com.ruoyi.company.domain.JmrCompany;

/**
 * 存储企业信息Service接口
 * 
 * @author ruoyi
 * @date 2020-09-27
 */
public interface IJmrCompanyService 
{
    /**
     * 查询存储企业信息
     * 
     * @param cId 存储企业信息ID
     * @return 存储企业信息
     */
    public JmrCompany selectJmrCompanyById(Long cId);

    /**
     * 查询存储企业信息列表
     * 
     * @param jmrCompany 存储企业信息
     * @return 存储企业信息集合
     */
    public List<JmrCompany> selectJmrCompanyList(JmrCompany jmrCompany);

    /**
     * 新增存储企业信息
     * 
     * @param jmrCompany 存储企业信息
     * @return 结果
     */
    public int insertJmrCompany(JmrCompany jmrCompany);

    /**
     * 修改存储企业信息
     * 
     * @param jmrCompany 存储企业信息
     * @return 结果
     */
    public int updateJmrCompany(JmrCompany jmrCompany);

    /**
     * 批量删除存储企业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJmrCompanyByIds(String ids);

    /**
     * 删除存储企业信息信息
     * 
     * @param cId 存储企业信息ID
     * @return 结果
     */
    public int deleteJmrCompanyById(Long cId);
}
