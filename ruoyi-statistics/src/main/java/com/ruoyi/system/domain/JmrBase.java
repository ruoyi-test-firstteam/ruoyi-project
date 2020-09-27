package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 存储匹配好的岗位信息（面向学生端）的依赖数据对象 jmr_base
 * 
 * @author wby
 * @date 2020-09-27
 */
public class JmrBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 匹配结果数据的id */
    private Integer jmrBId;

    /** 性别匹配值 */
    @Excel(name = "性别匹配值")
    private Integer jmrSexValue;

    /** 学校层次匹配值 */
    @Excel(name = "学校层次匹配值")
    private Integer jmrLevelValue;

    /** 专业匹配值 */
    @Excel(name = "专业匹配值")
    private Integer jmrProfessionValue;

    /** 学历匹配值 */
    @Excel(name = "学历匹配值")
    private Integer jmrHistoryValue;

    /** 外语水平匹配值 */
    @Excel(name = "外语水平匹配值")
    private Integer jmrLanguageValue;

    /** 期望薪资范围匹配值 */
    @Excel(name = "期望薪资范围匹配值")
    private Integer jmrRangeValue;

    /** 期望岗位匹配值 */
    @Excel(name = "期望岗位匹配值")
    private Integer jmrPositionValue;

    /** 就业意向地匹配值 */
    @Excel(name = "就业意向地匹配值")
    private Integer jmrCityValue;

    public void setJmrBId(Integer jmrBId) 
    {
        this.jmrBId = jmrBId;
    }

    public Integer getJmrBId() 
    {
        return jmrBId;
    }
    public void setJmrSexValue(Integer jmrSexValue) 
    {
        this.jmrSexValue = jmrSexValue;
    }

    public Integer getJmrSexValue() 
    {
        return jmrSexValue;
    }
    public void setJmrLevelValue(Integer jmrLevelValue) 
    {
        this.jmrLevelValue = jmrLevelValue;
    }

    public Integer getJmrLevelValue() 
    {
        return jmrLevelValue;
    }
    public void setJmrProfessionValue(Integer jmrProfessionValue) 
    {
        this.jmrProfessionValue = jmrProfessionValue;
    }

    public Integer getJmrProfessionValue() 
    {
        return jmrProfessionValue;
    }
    public void setJmrHistoryValue(Integer jmrHistoryValue) 
    {
        this.jmrHistoryValue = jmrHistoryValue;
    }

    public Integer getJmrHistoryValue() 
    {
        return jmrHistoryValue;
    }
    public void setJmrLanguageValue(Integer jmrLanguageValue) 
    {
        this.jmrLanguageValue = jmrLanguageValue;
    }

    public Integer getJmrLanguageValue() 
    {
        return jmrLanguageValue;
    }
    public void setJmrRangeValue(Integer jmrRangeValue) 
    {
        this.jmrRangeValue = jmrRangeValue;
    }

    public Integer getJmrRangeValue() 
    {
        return jmrRangeValue;
    }
    public void setJmrPositionValue(Integer jmrPositionValue) 
    {
        this.jmrPositionValue = jmrPositionValue;
    }

    public Integer getJmrPositionValue() 
    {
        return jmrPositionValue;
    }
    public void setJmrCityValue(Integer jmrCityValue) 
    {
        this.jmrCityValue = jmrCityValue;
    }

    public Integer getJmrCityValue() 
    {
        return jmrCityValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jmrBId", getJmrBId())
            .append("jmrSexValue", getJmrSexValue())
            .append("jmrLevelValue", getJmrLevelValue())
            .append("jmrProfessionValue", getJmrProfessionValue())
            .append("jmrHistoryValue", getJmrHistoryValue())
            .append("jmrLanguageValue", getJmrLanguageValue())
            .append("jmrRangeValue", getJmrRangeValue())
            .append("jmrPositionValue", getJmrPositionValue())
            .append("jmrCityValue", getJmrCityValue())
            .toString();
    }
}
