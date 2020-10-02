package com.ruoyi.quartz.task;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.student.domain.JmrBase;
import com.ruoyi.student.domain.JmrJob;
import com.ruoyi.student.domain.JmrJobMatchResult;
import com.ruoyi.student.domain.JmrStudent;
import com.ruoyi.student.service.IJmrBaseService;
import com.ruoyi.student.service.IJmrJobMatchResultService;
import com.ruoyi.student.service.IJmrJobService;
import com.ruoyi.student.service.IJmrStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{
    @Autowired
    private IJmrStudentService iJmrStudentService;

    @Autowired
    private IJmrJobService iJmrJobService;

    @Autowired
    private IJmrBaseService iJmrBaseService;

    @Autowired
    private IJmrJobMatchResultService jmrJobMatchResultService;


    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
        //查询所有学生信息
        ArrayList<JmrStudent> jmrStudents = (ArrayList<JmrStudent>) iJmrStudentService.selectJmrStudentList(null);
        //查询所有岗位信息
        ArrayList<JmrJob> jmrJobs = (ArrayList<JmrJob>) iJmrJobService.selectList();
        jmrJobMatchResultService.deleteJmrJobMatchResult();
        for(int i=0;i<jmrStudents.size();i++) {

            //取出每一条学生信息
            JmrStudent jmrStudent = jmrStudents.get(i);

            for (int j=0;j<jmrJobs.size();j++){

                //取每一个岗位信息
                JmrJob jmrJob = jmrJobs.get(j);
                //匹配结果表jmr_base表
                JmrBase jmrBaseResult = new JmrBase();
                //匹配结果统计表jmr_job_match_result表
                JmrJobMatchResult jmrJobMatchResult = new JmrJobMatchResult();
                //计分器，默认0
                int num = 0;
                if ((jmrJob.getjPoId()) == jmrStudent.getsEPosition().intValue()) {//判断岗位
                    jmrBaseResult.setJmrPositionValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrPositionValue(0);
                }
                if (jmrJob.getjSex() == jmrStudent.getsSex()) {//判断性别
                    jmrBaseResult.setJmrSexValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrSexValue(0);
                }
                if (jmrJob.getjEHistory() == jmrStudent.getsEHistory()) {//判断学历
                    jmrBaseResult.setJmrHistoryValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrHistoryValue(0);
                }
                if (jmrJob.getjCLevel() == jmrStudent.getsCLevel()) {//判断学校层次
                    jmrBaseResult.setJmrLevelValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrLevelValue(0);
                }
                if (jmrJob.getjFLanguage() == jmrStudent.getsFLanguage()) {//判断外语水平
                    jmrBaseResult.setJmrLanguageValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrLanguageValue(0);
                }
                if (jmrJob.getjPrId() == jmrStudent.getsProfession()) {//判断专业
                    jmrBaseResult.setJmrProfessionValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrProfessionValue(0);
                }
                if (jmrJob.getjSRange() == jmrStudent.getsSRange()) {//判断薪资水平
                    jmrBaseResult.setJmrRangeValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrRangeValue(0);
                }
                if (jmrJob.getjECity() == jmrStudent.getsECity()) {//判断就业意向地
                    jmrBaseResult.setJmrCityValue(1);
                    num += 10;
                } else {
                    jmrBaseResult.setJmrCityValue(0);
                }
                iJmrBaseService.insertJmrBase(jmrBaseResult);
                //插入学生id对应jmr_student表id
                jmrJobMatchResult.setJmrSId(jmrStudent.getsId());
                //插入岗位id对应jmr_job表id
                jmrJobMatchResult.setJmrJId(Long.valueOf(jmrJob.getjId()));
                //插入匹配数据表id,jmrBId
                jmrJobMatchResult.setJmrBId(Long.valueOf(jmrBaseResult.getJmrBId()));
                //插入匹配值
                jmrJobMatchResult.setJmrValue(Long.valueOf(num));
                //插入企业id
                jmrJobMatchResult.setJmrCId(Long.valueOf(jmrJob.getjCId()));
                jmrJobMatchResultService.insertJmrJobMatchResult(jmrJobMatchResult);
            }
        }
        System.out.println("自动匹配结束");
    }
}
