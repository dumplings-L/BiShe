package personal.xjl.jerrymouse.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//注解，定义该类是控制器
@Controller
//如何访问控制器，像servlet的url_pattern
@RequestMapping("/Student")
public class StudentController {
    //select,list,分层的请求形式
    @RequestMapping("list.do")
    //响应给用户的是html中的body部分
    @ResponseBody
    public String list(){
        //返回字符串list students给用户
        return "list students";
    }
    //add,转向到addStudent.html页面
    @RequestMapping("toAdd.do")
    public String toAdd(){
        return "addStudent";
    }
    //update
    //delete
    //login
    @RequestMapping("login.do")
    @ResponseBody
    public String login(){
        return "welcome you!";
    }
}
