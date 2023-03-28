package personal.xjl.jerrymouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.xjl.jerrymouse.entity.Admin;
import personal.xjl.jerrymouse.service.AdminServiceImpl;
import personal.xjl.jerrymouse.service.StudentServiceImpl;
import personal.xjl.jerrymouse.service.TeacherServiceImpl;

import javax.servlet.http.HttpSession;

@Controller

public class LoginController {
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    TeacherServiceImpl teacherService;
    @Autowired
    AdminServiceImpl adminService;
    //login.html
    @RequestMapping("login.html")
    public String login(){
        return "login";
    }
    //Login.do
    @RequestMapping("Login.do")
    public String login(String username, String pwd, int type, HttpSession session){
        switch (type){
            case 1:{
                if(studentService.login(username,pwd))
                {
                    session.setAttribute("username",username);
                    return "main";
                }
                else
                    return "login";

            }
            case 2:{
                if(teacherService.login(username,pwd))
                {
                    session.setAttribute("username",username);
                    return "main";
                }
                else
                    return "login";
            }
            case 3:{
                if(adminService.login(username,pwd))
                {
                    session.setAttribute("username",username);
                    return "main";
                }
                else
                    return "login";
            }

        }
        return "404";
    }
}
