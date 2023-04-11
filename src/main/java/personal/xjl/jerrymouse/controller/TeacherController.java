package personal.xjl.jerrymouse.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import personal.xjl.jerrymouse.entity.Course;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.entity.Teacher;
import personal.xjl.jerrymouse.service.CourseServiceImpl;
import personal.xjl.jerrymouse.service.TeacherServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Teacher")
@Api(value = "teacherController",tags = "Teacher Controller")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherServiceImpl;
    //add
/*    @RequestMapping("add.do")
    @ApiOperation(value = "add.do",tags = "add teacher")
    public String add(Teacher teacher, HttpSession session){
        //获取session对象teachers,List,所有的教师信息
        List<Teacher> teacherList= (List<Teacher>) session.getAttribute("teachers");
        if(teacherList==null)
            teacherList=new ArrayList<>();
        //添加一条新的teacher
        teacherList.add(teacher);
        //新的teacherList设置到session对象teachers
        session.setAttribute("teachers",teacherList);
        return "listTeachers";
    }*/
    //list.do
    @RequestMapping("list.do")
    public String list(Model model, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Teacher> teachers=teacherServiceImpl.findAllTeachers();
//        model.addAttribute("teachers",teachers);
        PageInfo pageInfo=new PageInfo<Teacher>(teachers,pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "listTeachers";

    }
    //add.do
    @RequestMapping("add.do")
    public String add(Teacher teacher,Model model){
        teacherServiceImpl.addTeacher(teacher);
        return list(model,1,5);
    }
    //toAdd.do,准备增加
    @Autowired
    CourseServiceImpl courseServiceImpl;
    @RequestMapping("toAdd.do")
    public String toAdd(Model model){
        List<Course>  courses=courseServiceImpl.findAllCourses();
        model.addAttribute("courses",courses);
        return "addTeacher";
    }

    //delete.do删除教师
    @RequestMapping("delete.do")
    public String delete(int id,Model model){
        teacherServiceImpl.removeStudent(id);
        return list(model,1,5);
    }
    @RequestMapping("toUpdate.do")
    public String toUpdate(int id,Model model){
        //
        Teacher teacher = teacherServiceImpl.selectUpdateTeacher(id);
        //
        model.addAttribute("teacher",teacher);
        return "updateTeacher";
    }

    @RequestMapping("update.do")
    public String update(Teacher newTeacher,Model model){
        teacherServiceImpl.UpdateTeacher(newTeacher);
        return list(model,1,5);
    }
}
