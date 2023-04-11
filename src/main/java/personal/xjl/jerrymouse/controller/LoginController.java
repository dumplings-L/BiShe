package personal.xjl.jerrymouse.controller;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.xjl.jerrymouse.service.AdminServiceImpl;
import personal.xjl.jerrymouse.service.StudentServiceImpl;
import personal.xjl.jerrymouse.service.TeacherServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/Login")
public class LoginController {
    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    StudentServiceImpl studentService;
    @RequestMapping("login.html")
    public String login(){
        return "login";
    }
    //login.do
    @RequestMapping("login.do")
    public String login(String name, String password, String type, HttpSession session){
        switch (type){
            case "1":{
                if (studentService.login(name, password)){
                    session.setAttribute("username",name);
                    return "main";
                }
                else{
                    return "login";
                }
            }
            case "2":{
                if (teacherService.login(name, password)){
                    session.setAttribute("username",name);
                    return "main";
                }
                else{
                    return "login";
                }

            }
            case "3":{
                if (adminService.login(name, password)){
                    session.setAttribute("username",name);
                    return "main";
                }
                else{
                    return "login";
                }

            }

        }
        return "404";
    }

}
