package com.ruoyi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.company.mapper.JmrCompanyMapper;
import com.ruoyi.company.domain.JmrCompany;
import com.ruoyi.company.service.IJmrCompanyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 存储企业信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-27
 */
@Service
public class JmrCompanyServiceImpl implements IJmrCompanyService 
{
    @Autowired
    private JmrCompanyMapper jmrCompanyMapper;

    /**
     * 查询存储企业信息
     * 
     * @param cId 存储企业信息ID
     * @return 存储企业信息
     */
    @Override
    public JmrCompany selectJmrCompanyById(Long cId)
    {
        return jmrCompanyMapper.selectJmrCompanyById(cId);
    }

    /**
     * 查询存储企业信息列表
     * 
     * @param jmrCompany 存储企业信息
     * @return 存储企业信息
     */
    @Override
    public List<JmrCompany> selectJmrCompanyList(JmrCompany jmrCompany)
    {
        return jmrCompanyMapper.selectJmrCompanyList(jmrCompany);
    }

    /**
     * 新增存储企业信息
     * 
     * @param jmrCompany 存储企业信息
     * @return 结果
     */
    @Override
    public int insertJmrCompany(JmrCompany jmrCompany)
    {
        return jmrCompanyMapper.insertJmrCompany(jmrCompany);
    }

    /**
     * 修改存储企业信息
     * 
     * @param jmrCompany 存储企业信息
     * @return 结果
     */
    @Override
    public int updateJmrCompany(JmrCompany jmrCompany)
    {
        return jmrCompanyMapper.updateJmrCompany(jmrCompany);
    }

    /**
     * 删除存储企业信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJmrCompanyByIds(String ids)
    {
        return jmrCompanyMapper.deleteJmrCompanyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除存储企业信息信息
     * 
     * @param cId 存储企业信息ID
     * @return 结果
     */
    @Override
    public int deleteJmrCompanyById(Long cId)
    {
        return jmrCompanyMapper.deleteJmrCompanyById(cId);
    }
}
