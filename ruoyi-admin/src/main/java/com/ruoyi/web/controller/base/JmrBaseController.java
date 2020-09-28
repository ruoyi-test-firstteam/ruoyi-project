package com.ruoyi.web.controller.base;

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
import com.ruoyi.system.domain.JmrBase;
import com.ruoyi.system.service.IJmrBaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 存储匹配好的岗位信息（面向学生端）的依赖数据Controller
 * 
 * @author wby
 * @date 2020-09-27
 */
@Controller
@RequestMapping("/system/base")
public class JmrBaseController extends BaseController
{
    private String prefix = "system/base";

    @Autowired
    private IJmrBaseService jmrBaseService;

    @RequiresPermissions("system:base:view")
    @GetMapping()
    public String base()
    {
        return prefix + "/base";
    }

    /**
     * 查询存储匹配好的岗位信息（面向学生端）的依赖数据列表
     */
    @RequiresPermissions("system:base:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JmrBase jmrBase)
    {
        startPage();
        List<JmrBase> list = jmrBaseService.selectJmrBaseList(jmrBase);
        return getDataTable(list);
    }

    /**
     * 导出存储匹配好的岗位信息（面向学生端）的依赖数据列表
     */
    @RequiresPermissions("system:base:export")
    @Log(title = "存储匹配好的岗位信息（面向学生端）的依赖数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JmrBase jmrBase)
    {
        List<JmrBase> list = jmrBaseService.selectJmrBaseList(jmrBase);
        ExcelUtil<JmrBase> util = new ExcelUtil<JmrBase>(JmrBase.class);
        return util.exportExcel(list, "base");
    }

    /**
     * 新增存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    @RequiresPermissions("system:base:add")
    @Log(title = "存储匹配好的岗位信息（面向学生端）的依赖数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmrBase jmrBase)
    {
        return toAjax(jmrBaseService.insertJmrBase(jmrBase));
    }

    /**
     * 修改存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    @GetMapping("/edit/{jmrBId}")
    public String edit(@PathVariable("jmrBId") Integer jmrBId, ModelMap mmap)
    {
        JmrBase jmrBase = jmrBaseService.selectJmrBaseById(jmrBId);
        mmap.put("jmrBase", jmrBase);
        return prefix + "/edit";
    }

    /**
     * 修改保存存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    @RequiresPermissions("system:base:edit")
    @Log(title = "存储匹配好的岗位信息（面向学生端）的依赖数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmrBase jmrBase)
    {
        return toAjax(jmrBaseService.updateJmrBase(jmrBase));
    }

    /**
     * 删除存储匹配好的岗位信息（面向学生端）的依赖数据
     */
    @RequiresPermissions("system:base:remove")
    @Log(title = "存储匹配好的岗位信息（面向学生端）的依赖数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmrBaseService.deleteJmrBaseByIds(ids));
    }
}
