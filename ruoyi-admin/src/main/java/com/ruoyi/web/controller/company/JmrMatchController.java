package com.ruoyi.web.controller.company;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.company.domain.JmrJob;
import com.ruoyi.company.domain.JmrStudent;
import com.ruoyi.company.domain.JmrBase;
import com.ruoyi.company.domain.JmrStudentMatchResult;
import com.ruoyi.company.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * 企业匹配岗位控制层
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
@Controller
@RequestMapping("/company/match")
public class JmrMatchController extends BaseController
{
    private String prefix = "company/match";

    @Autowired
    private IJmrJobService jmrJobService;
    @Autowired
    private IJmrBaseService jmrBaseService;
    @Autowired
    private IJmrCompanyService companyService;
    @Autowired
    private IJmrStudentService studentService;
    @Autowired
    private IJmrStudentMatchResultService studentMatchResultService;
    @RequiresPermissions("company:match:view")
    @GetMapping()
    public String job()
    {
        return prefix + "/match";
    }



    //岗位匹配学生方法
    @RequestMapping("/test")
    public void MatchResult(){

        //1.查询某个岗位
       //JmrCompany jmrCompany = companyService.selectJmrCompanyById(Integer.valueOf(1).longValue());
        JmrJob jmrJob = jmrJobService.selectJmrJobById(1);//某个企业的一个岗位
        //2.查询所有学生表 （集合）
        ArrayList<JmrStudent> lists = (ArrayList<JmrStudent>) studentService.selectJmrStudentList(null);
        //3.匹配算法
        for(int i=0;i<lists.size();i++){
            JmrStudent jmrStudent = lists.get(i);//取每一个学生
            JmrBase result=new JmrBase();//匹配结果实例表
            float num=0;//默认无分数
            //判断匹配数据 并存放在匹配结果表中JmrStudentMatchResult中 每次存储在数据库此表中一次
            if(jmrStudent.getsEPosition().equals(jmrJob.getjPoId())){//判断岗位id
                result.setSmr_position_value(1);
                num+=12.5;
            }else{result.setSmr_position_value(0);}
            if(jmrStudent.getsSex().equals(jmrJob.getjSex())){//判断性别
                result.setSmr_sex_value(1);
                num+=12.5;
            }else{result.setSmr_sex_value(0);}
            if(jmrStudent.getsEHistory().equals(jmrJob.getjEHistory())){//判断学历
                result.setSmr_history_value(1);
                num+=12.5;;
            }else{result.setSmr_history_value(0);}
            if(jmrStudent.getsCLevel().equals(jmrJob.getjCLevel())){//判断院校层次
                result.setSmr_level_value(1);
                num+=12.5;
            }else{result.setSmr_level_value(0);}
            if(jmrStudent.getsFLanguage().equals(jmrJob.getjFLanguage())){//判断外语水平
                result.setSmr_language_value(1);
                num+=12.5;
            }else{result.setSmr_language_value(0);}
            if(jmrStudent.getsProfession().equals(jmrJob.getjPrId())){//判断专业
                result.setSmr_profession_value(1);
                num+=12.5;
            }else{result.setSmr_profession_value(0);}
            if( jmrStudent.getsSRange().equals(jmrJob.getjSRange())){//判断薪资范围
                result.setSmr_range_value(1);
                num+=12.5;
            }else{ result.setSmr_range_value(0); }
            if(jmrStudent.getsECity().equals(jmrJob.getjECity())){//判断就业意向地
                result.setJmr_city_value(1);
                num+=12.5;
            }else{result.setJmr_city_value(1);}

            jmrBaseService.save(result);
            Integer smr_id = result.getSmr_b_id();//存储的评价表返回的id
            System.out.println(result);

            JmrStudentMatchResult studentMatchResult=new JmrStudentMatchResult();
            studentMatchResult.setSmrCId(jmrJob.getjCId().intValue());//存储企业id
            studentMatchResult.setSmrJId(jmrJob.getjPoId());//存储岗位id
            studentMatchResult.setSmrSId(jmrStudent.getsId().intValue());//学生id
            //studentMatchResult.setSmrRId(0);//简历id

            studentMatchResult.setSmrBId(smr_id);//评价表返回的id
            studentMatchResult.setSmrValue((int)num);
            int i1 = studentMatchResultService.insertJmrStudentMatchResult(studentMatchResult);//存储匹配好的信息
            System.out.println("匹配分数："+num);
            System.out.println(i1);
        }
        System.out.println(lists);


    }

















//    /**
//     * 查询企业岗位管理3.0列表
//     */
//    @RequiresPermissions("company:job:list")
//    @PostMapping("/list")
//    @ResponseBody
//    public TableDataInfo list(JmrJob jmrJob, HttpServletRequest request)
//    {
//        startPage();
//        //jmrJob.setjExpire(new Date());
//        // 获取当前的用户信息
//        SysUser sysUser = ShiroUtils.getSysUser();
//        // 获取当前的用户名称
//        String userName = sysUser.getLoginName();
//
//        JmrCompany jmrCompany = companyService.selectJmrCompanyByPhone(userName);
//        if(jmrCompany!=null){
//            //System.out.println("进入判断 公司用户");
//            jmrJob.setjCId(jmrCompany.getcId());
//            request.getSession().setAttribute("company",jmrCompany);
//            request.getSession().setAttribute("isComAcount","yes");//添加方法 企业id 多个企业选择或者仅添加自己 做判断
//        }else{
//
//            request.getSession().setAttribute("isComAcount","no");
//        }
//        List<JmrJob> list = jmrJobService.selectJmrJobList(jmrJob);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出企业岗位管理3.0列表
//     */
//    @RequiresPermissions("company:job:export")
//    @Log(title = "企业岗位管理3.0", businessType = BusinessType.EXPORT)
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(JmrJob jmrJob)
//    {
//        List<JmrJob> list = jmrJobService.selectJmrJobList(jmrJob);
//        ExcelUtil<JmrJob> util = new ExcelUtil<JmrJob>(JmrJob.class);
//        return util.exportExcel(list, "job");
//    }
//
//    /**
//     * 新增企业岗位管理3.0
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存企业岗位管理3.0
//     */
//    @RequiresPermissions("company:job:add")
//    @Log(title = "企业岗位管理3.0", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(JmrJob jmrJob)
//    {
//        return toAjax(jmrJobService.insertJmrJob(jmrJob));
//    }
//
//    /**
//     * 修改企业岗位管理3.0
//     */
//    @GetMapping("/edit/{jId}")
//    public String edit(@PathVariable("jId") Integer jId, ModelMap mmap)
//    {
//        JmrJob jmrJob = jmrJobService.selectJmrJobById(jId);
//        mmap.put("jmrJob", jmrJob);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存企业岗位管理3.0
//     */
//    @RequiresPermissions("company:job:edit")
//    @Log(title = "企业岗位管理3.0", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(JmrJob jmrJob)
//    {
//        return toAjax(jmrJobService.updateJmrJob(jmrJob));
//    }
//
//    /**
//     * 删除企业岗位管理3.0
//     */
//    @RequiresPermissions("company:job:remove")
//    @Log(title = "企业岗位管理3.0", businessType = BusinessType.DELETE)
//    @PostMapping( "/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(jmrJobService.deleteJmrJobByIds(ids));
//    }
}
