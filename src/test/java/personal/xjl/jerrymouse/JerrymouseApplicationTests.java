package personal.xjl.jerrymouse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.mapper.StudentMapper;

import java.util.List;

@SpringBootTest
class JerrymouseApplicationTests {
   //自动注入，装配
    @Autowired
    StudentMapper studentMapper;
    @Test
    void contextLoads() {
        Student student=new Student();
        student.setName("musi");
        student.setPassword("musi");
        student.setSex(0);
        student.setClazz("21java3");
        studentMapper.insert(student);
        List<Student> students=studentMapper.queryAll();
        students.forEach(e-> System.out.println(e));
    }

}
