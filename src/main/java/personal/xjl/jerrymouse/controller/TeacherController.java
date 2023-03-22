package personal.xjl.jerrymouse.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.xjl.jerrymouse.entity.Course;
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
    public String list(Model model){
        List<Teacher> teachers=teacherServiceImpl.findAllTeachers();
        model.addAttribute("teachers",teachers);
        return "listTeachers";
    }
    //add.do
    @RequestMapping("add.do")
    public String add(Teacher teacher,Model model){
        teacherServiceImpl.addTeacher(teacher);
        return list(model);
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

}
