package personal.xjl.jerrymouse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.xjl.jerrymouse.entity.Course;
import personal.xjl.jerrymouse.service.CourseServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    CourseServiceImpl courseServiceImpl;
    @RequestMapping("list.do")
    public String list(Model model){
        List<Course> courses=courseServiceImpl.findAllCourses();
        model.addAttribute("courses",courses);
        return "listCourses";
    }
}
