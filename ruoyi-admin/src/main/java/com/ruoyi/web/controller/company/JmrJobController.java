package com.ruoyi.web.controller.company;

import java.util.Date;
import java.util.List;

import com.ruoyi.company.domain.JmrCompany;
import com.ruoyi.company.service.IJmrCompanyService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.company.domain.JmrJob;
import com.ruoyi.company.service.IJmrJobService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 企业岗位管理3.0Controller
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
@Controller
@RequestMapping("/company/job")
public class JmrJobController extends BaseController
{
    private String prefix = "company/job";

    @Autowired
    private IJmrJobService jmrJobService;
    @Autowired
    private IJmrCompanyService companyService;


    @RequiresPermissions("company:job:view")
    @GetMapping()
    public String job()
    {
        return prefix + "/job";
    }

    /**
     * 查询企业岗位管理3.0列表
     */
    @RequiresPermissions("company:job:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmrJob jmrJob, HttpServletRequest request)
    {
        startPage();
        //jmrJob.setjExpire(new Date());
        // 获取当前的用户信息
        SysUser sysUser = ShiroUtils.getSysUser();
        // 获取当前的用户名称
        String userName = sysUser.getLoginName();

        JmrCompany jmrCompany = companyService.selectJmrCompanyByPhone(userName);
        if(jmrCompany!=null){
            //System.out.println("进入判断 公司用户");
            jmrJob.setjCId(jmrCompany.getcId());
            request.getSession().setAttribute("company",jmrCompany);
            request.getSession().setAttribute("isComAcount","yes");//添加方法 企业id 多个企业选择或者仅添加自己 做判断
        }else{

            request.getSession().setAttribute("isComAcount","no");
        }
        List<JmrJob> list = jmrJobService.selectJmrJobList(jmrJob);
        return getDataTable(list);
    }

    /**
     * 导出企业岗位管理3.0列表
     */
    @RequiresPermissions("company:job:export")
    @Log(title = "企业岗位管理3.0", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JmrJob jmrJob)
    {
        List<JmrJob> list = jmrJobService.selectJmrJobList(jmrJob);
        ExcelUtil<JmrJob> util = new ExcelUtil<JmrJob>(JmrJob.class);
        return util.exportExcel(list, "job");
    }

    /**
     * 新增企业岗位管理3.0
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业岗位管理3.0
     */
    @RequiresPermissions("company:job:add")
    @Log(title = "企业岗位管理3.0", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmrJob jmrJob)
    {
        return toAjax(jmrJobService.insertJmrJob(jmrJob));
    }

    /**
     * 修改企业岗位管理3.0
     */
    @GetMapping("/edit/{jId}")
    public String edit(@PathVariable("jId") Integer jId, ModelMap mmap)
    {
        JmrJob jmrJob = jmrJobService.selectJmrJobById(jId);
        mmap.put("jmrJob", jmrJob);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业岗位管理3.0
     */
    @RequiresPermissions("company:job:edit")
    @Log(title = "企业岗位管理3.0", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmrJob jmrJob)
    {
        return toAjax(jmrJobService.updateJmrJob(jmrJob));
    }

    /**
     * 删除企业岗位管理3.0
     */
    @RequiresPermissions("company:job:remove")
    @Log(title = "企业岗位管理3.0", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmrJobService.deleteJmrJobByIds(ids));
    }
}
