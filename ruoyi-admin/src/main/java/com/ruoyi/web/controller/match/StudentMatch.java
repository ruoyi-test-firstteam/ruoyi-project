package com.ruoyi.web.controller.match;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.student.domain.JmrStudent;
import com.ruoyi.student.service.IJmrStudentService;
import com.ruoyi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student/match")
public class StudentMatch extends BaseController {
    @Autowired
    private IJmrStudentService iJmrStudentService;

    public String matching(){
        // 获取当前的用户信息
        SysUser user = ShiroUtils.getSysUser();
        // 获取当前的用户名称
        String userName = user.getLoginName();
        //查询学生信息列表
        JmrStudent jmrStudent = iJmrStudentService.selectJmrStudentByPhone(userName);
        return null;

    }
}
