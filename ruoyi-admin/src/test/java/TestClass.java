import com.ruoyi.RuoYiApplication;
import com.ruoyi.company.domain.JmrJob;
import com.ruoyi.company.domain.JmrStudent;
import com.ruoyi.company.domain.JmrBase;
import com.ruoyi.company.domain.JmrStudentMatchResult;
import com.ruoyi.company.service.IJmrBaseService;
import com.ruoyi.company.service.IJmrJobService;
import com.ruoyi.company.service.IJmrStudentMatchResultService;
import com.ruoyi.company.service.IJmrStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@ContextConfiguration
@SpringBootTest(classes = RuoYiApplication.class)
@RunWith(SpringRunner.class)
public class TestClass {

    @Autowired
    private IJmrStudentService jmrStudentService;
    @Autowired
    private IJmrJobService jmrJobService;
    @Autowired
    private IJmrBaseService jmrBaseService;
    @Autowired
    private IJmrStudentMatchResultService studentMatchResultService;
    @Test
    public void TestOne(){
        JmrJob jmrJob = jmrJobService.selectJmrJobById(1);
        //System.out.println("jmrJob = " + jmrJob);
        List<JmrStudent> lists = jmrStudentService.selectJmrStudentList(null);
        //System.out.println("jmrStudents W= " + lists);
        //System.out.println(lists.get(0).getsEPosition().equals(jmrJob.getjPoId()));
        JmrStudent jmrStudent = lists.get(0);
        JmrBase result=new JmrBase();//匹配结果实例表
        float num=0;
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

        JmrStudentMatchResult studentMatchResult=new JmrStudentMatchResult();
        studentMatchResult.setSmrCId(jmrJob.getjCId().intValue());//存储企业id
        studentMatchResult.setSmrJId(jmrJob.getjPoId());//存储岗位id
        studentMatchResult.setSmrSId(jmrStudent.getsId().intValue());//学生id
        studentMatchResult.setSmrRId(1);//简历id
        studentMatchResult.setSmrBId(smr_id);//评价表返回的id
        studentMatchResult.setSmrValue((int)num);
        int i1 = studentMatchResultService.insertJmrStudentMatchResult(studentMatchResult);//存储匹配好的信息
        System.out.println("匹配分数："+num);
        System.out.println(i1);
    }
}
