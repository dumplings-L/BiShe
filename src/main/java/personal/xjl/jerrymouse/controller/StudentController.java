package personal.xjl.jerrymouse.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import personal.xjl.jerrymouse.entity.Product;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.mapper.StudentMapper;
import personal.xjl.jerrymouse.service.StudentServiceImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//注解，定义该类是控制器，spring在扫描后会自动生成一个bean的对象，他的名字是"studentController"
@Controller
//如何访问控制器，像servlet的url_pattern
@RequestMapping("/Student")
@Api(value = "this is a  student api",tags = "students api")
public class StudentController {
    private final Log log= LogFactory.getLog(StudentController.class);
    //自动注入,业务对象
    @Autowired
    StudentServiceImpl studentServiceImpl;
    //select,list,分层的请求形式
    @RequestMapping("list.do")
    //响应给用户的是html中的body部分
    //@ResponseBody
    @ApiOperation(value = "listStudents",notes = "list methods,显示学生",tags="list Students")
    public String list(Model model,@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "5") int pageSize){
        log.info("this is my info log");
//        log.warn("this is my warn log");
        log.error("this is my error log");
        PageHelper.startPage(pageNum,pageSize);
        //获取数据库里student表的所有数据
        List<Student> students=studentServiceImpl.findAllStudents();

        PageInfo pageInfo=new PageInfo<Student>(students,pageSize);
        model.addAttribute("pageInfo", pageInfo);
//        model.addAttribute("students",students);
        //返回字符串list students给用户
        return "listStudents";
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
    //@ResponseBody
    public String login(String username, @RequestParam("pwd") String password, String freeLogin, HttpServletResponse res,
                        Model model){
        if(studentServiceImpl.login(username,password))
        {
            //如果用户勾选了“七天免登录”，创建cookie
            if (freeLogin!=null){
                Cookie username_cookie=new Cookie("username",username);
                username_cookie.setMaxAge(7*24*60*60);
                Cookie pwd_cookie=new Cookie("pwd",password);
                res.addCookie(username_cookie);
                res.addCookie(pwd_cookie);
            }
            return list(model,1,5);
        }
        else
        {
            return "login";
        }
      //  return "welcome you!"+username+",your password is  "+password;
    }
    @RequestMapping("getPage.do")
    public String getPage(String page){
        return page;
    }
    @RequestMapping("add.do")
    public String add(Student student, Model model, HttpSession session){
        studentServiceImpl.addStudent(student);
        System.out.println(session.getId());
        session.setAttribute("username",student.getName());
        return list(model,1,5);
    }
    //delete.do删除学生
    @RequestMapping("delete.do")
    public String delete(int id,Model model){
        studentServiceImpl.removeStudent(id);
        return list(model,1,5);
    }
    //toUpdate.do,带原数据跳转到修改页面
    @RequestMapping("toUpdate.do")
    public String toUpdate(int id, Model model){
        //查找原来数据
        Student student = studentServiceImpl.selectStudentById(id);
        //用student渲染updateStudent.html
        model.addAttribute("student",student);
        return "updateStudent";
    }
    //update.do,修改后的数据提交到数据库，跳转到页面
    @RequestMapping("update.do")
    public String update(Student newStudent,Model model){
        //提交原数据
        studentServiceImpl.UpdateStudent(newStudent);
        return list(model,1,5);
    }
    //lofout.do
    @RequestMapping("logout.do")
    public String logout(HttpSession session){
        //没收通行证
        session.setAttribute("username",null);
        return "login";
    }


}
