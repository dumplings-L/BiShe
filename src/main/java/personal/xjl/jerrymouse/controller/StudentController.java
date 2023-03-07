package personal.xjl.jerrymouse.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import personal.xjl.jerrymouse.entity.Product;
import personal.xjl.jerrymouse.entity.Student;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//注解，定义该类是控制器
@Controller
//如何访问控制器，像servlet的url_pattern
@RequestMapping("/Student")
@Api(value = "this is a  student api",tags = "students api")
public class StudentController {
    //select,list,分层的请求形式
    @RequestMapping("list.do")
    //响应给用户的是html中的body部分
    @ResponseBody
    @ApiOperation(value = "listStudents",notes = "list methods,显示学生",tags="list Students")
    public String list(){
        //返回字符串list students给用户
        return "list students";
    }
    //add,转向到addStudent.html页面
    @RequestMapping("toAdd.do")
    public String toAdd(Model model){
        List<Product> students=new ArrayList<>();
        for (int i=1;i<=10;i++)
        {
            students.add(new Product("product"+i,i,i));
        }
        model.addAttribute("students",students);
        //传出数据，名字username,值是apolo
        model.addAttribute("username","apolo");
        model.addAttribute("pwd","123");
        return "addStudent";
    }
    //update
    //delete
    //login
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,@RequestParam("pwd") String password){
        return "welcome you!"+username+",your password is  "+password;
    }
    @RequestMapping("getPage.do")
    public String getPage(String page){
        return page;
    }
    @RequestMapping("add.do")
    public String add(Student student, Model model, HttpSession session){
        session.setAttribute("username",student.getName());
        return "testSession";
    }
}
