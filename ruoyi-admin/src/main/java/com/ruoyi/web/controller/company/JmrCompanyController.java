package com.ruoyi.web.controller.company;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.company.domain.JmrCompany;
import com.ruoyi.company.service.IJmrCompanyService;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.catalina.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 存储企业信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-27
 */
@Controller
@RequestMapping("/company/company")
public class JmrCompanyController extends BaseController
{
    private String prefix = "company/company";

    @Autowired
    private IJmrCompanyService jmrCompanyService;

    @Autowired
    private IJmrCompanyService companyService;

    @RequiresPermissions("company:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询存储企业信息列表
     */
    @RequiresPermissions("company:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HttpServletRequest request)
    {

        //startPage();
        //根据登录的用户名判断是否是企业用户
        //String username = (String) request.getSession().getAttribute("username");
        // 获取当前的用户信息
              SysUser sysUser = ShiroUtils.getSysUser();
        // 获取当前的用户名称
              String userName = sysUser.getLoginName();
        JmrCompany jmrCompany = companyService.selectJmrCompanyByPhone(userName);
//        if(jmrCompany==null){//管理员账号
//            request.getSession().setAttribute("message","admin");
//        }
//        System.out.println(request.getSession().getAttribute("message"));

        List<JmrCompany> list = jmrCompanyService.selectJmrCompanyList(jmrCompany);
        return getDataTable(list);
    }

    /**
     * 导出存储企业信息列表
     */
    @RequiresPermissions("company:company:export")
    @Log(title = "存储企业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JmrCompany jmrCompany)
    {
        List<JmrCompany> list = jmrCompanyService.selectJmrCompanyList(jmrCompany);
        ExcelUtil<JmrCompany> util = new ExcelUtil<JmrCompany>(JmrCompany.class);
        return util.exportExcel(list, "company");
    }

    /**
     * 新增存储企业信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存存储企业信息
     */
    @RequiresPermissions("company:company:add")
    @Log(title = "存储企业信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JmrCompany jmrCompany)
    {
        return toAjax(jmrCompanyService.insertJmrCompany(jmrCompany));
    }

    /**
     * 修改存储企业信息
     */
    @GetMapping("/edit/{cId}")
    public String edit(@PathVariable("cId") Long cId, ModelMap mmap)
    {
        JmrCompany jmrCompany = jmrCompanyService.selectJmrCompanyById(cId);
        mmap.put("jmrCompany", jmrCompany);
        return prefix + "/edit";
    }

    /**
     * 修改保存存储企业信息
     */
    @RequiresPermissions("company:company:edit")
    @Log(title = "存储企业信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JmrCompany jmrCompany,HttpServletRequest request)
    {
        int i = jmrCompanyService.updateJmrCompany(jmrCompany);
//        if(i>0){
//            request.getSession().setAttribute("company",company());
//        }
        return toAjax(i);
    }

    /**
     * 删除存储企业信息
     */
    @RequiresPermissions("company:company:remove")
    @Log(title = "存储企业信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jmrCompanyService.deleteJmrCompanyByIds(ids));
    }
}
