package com.ruoyi.web.controller.company;

import java.util.List;
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

/**
 * 存储企业保存的岗位信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-27
 */
@Controller
@RequestMapping("/company/job")
public class JmrJobController extends BaseController
{
    private String prefix = "company/job";

    @Autowired
    private IJmrJobService jmrJobService;

    @RequiresPermissions("company:job:view")
    @GetMapping()
    public String job()
    {
        return prefix + "/job";
    }

    /**
     * 查询存储企业保存的岗位信息列表
     */
    @RequiresPermissions("company:job:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmrJob jmrJob)
    {
        startPage();
        List<JmrJob> list = jmrJobService.selectJmrJobList(jmrJob);
        return getDataTable(list);
    }

    /**
     * 导出存储企业保存的岗位信息列表
     */
    @RequiresPermissions("company:job:export")
    @Log(title = "存储企业保存的岗位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JmrJob jmrJob)
    {
        List<JmrJob> list = jmrJobService.selectJmrJobList(jmrJob);
        ExcelUtil<JmrJob> util = new ExcelUtil<JmrJob>(JmrJob.class);
        return util.exportExcel(list, "job");
    }

    /**
     * 新增存储企业保存的岗位信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存存储企业保存的岗位信息
     */
    @RequiresPermissions("company:job:add")
    @Log(title = "存储企业保存的岗位信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmrJob jmrJob)
    {
        return toAjax(jmrJobService.insertJmrJob(jmrJob));
    }

    /**
     * 修改存储企业保存的岗位信息
     */
    @GetMapping("/edit/{jId}")
    public String edit(@PathVariable("jId") Integer jId, ModelMap mmap)
    {
        JmrJob jmrJob = jmrJobService.selectJmrJobById(jId);
        mmap.put("jmrJob", jmrJob);
        return prefix + "/edit";
    }

    /**
     * 修改保存存储企业保存的岗位信息
     */
    @RequiresPermissions("company:job:edit")
    @Log(title = "存储企业保存的岗位信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmrJob jmrJob)
    {
        return toAjax(jmrJobService.updateJmrJob(jmrJob));
    }

    /**
     * 删除存储企业保存的岗位信息
     */
    @RequiresPermissions("company:job:remove")
    @Log(title = "存储企业保存的岗位信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmrJobService.deleteJmrJobByIds(ids));
    }
}
