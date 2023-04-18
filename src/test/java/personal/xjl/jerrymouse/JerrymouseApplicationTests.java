package personal.xjl.jerrymouse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.mapper.StudentMapper;
import personal.xjl.jerrymouse.spring.Car;

import java.util.List;

@SpringBootTest
class JerrymouseApplicationTests {
   //自动注入，装配
//    @Autowired
//    StudentMapper studentMapper;
//    @Autowired
//    Student zhangsan;
    @Autowired
    @Qualifier("myBenz")//按名称注入对象
    Car myCar;
    @Test
    void contextLoads() {
//        Student student=new Student();
//        student.setName("musi");
//        student.setPassword("musi");
//        student.setSex(0);
//        student.setClazz("21java3");
//        studentMapper.insert(student);
//        List<Student> students=studentMapper.queryAll();
//        students.forEach(e-> System.out.println(e));
//        zhangsan.setName("zhangsan1");
//        System.out.println(zhangsan);
        System.out.println(myCar);
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Car c1=(Car)applicationContext.getBean("myBaoMa");
        System.out.println(c1);
        Car c2=(Car)applicationContext.getBean("myBYD");
        System.out.println(c2);
        Car c3=(Car)applicationContext.getBean("myNissan");
        System.out.println(c3);
    }

}
