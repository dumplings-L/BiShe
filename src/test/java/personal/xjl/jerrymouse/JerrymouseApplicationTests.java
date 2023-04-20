package personal.xjl.jerrymouse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.mapper.StudentMapper;
import personal.xjl.jerrymouse.spring.*;

import java.util.List;

@SpringBootTest
class JerrymouseApplicationTests {
   //自动注入，装配
//    @Autowired
//    StudentMapper studentMapper;
//    @Autowired
//    Student zhangsan;
//    @Autowired
//    @Qualifier("myBenz")//按名称注入对象
//    Car myCar;
//    @Autowired
//    @Qualifier("zhangsan")
//    Human human;


    @Autowired
    @Qualifier("myCattle")
    Cattle myCattle;
    @Autowired
    @Qualifier("myCattleCar")
    CattleCar myCattleCar;
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

        System.out.println(myCattle);
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Cattle niu1=(Cattle) applicationContext.getBean("niuMoWang");
        System.out.println(niu1);
        System.out.println(myCattleCar);
        CattleCar niu2=(CattleCar) applicationContext.getBean("niuMoWang2");
        System.out.println(niu2);


//        System.out.println(myCar);
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
//        Car c1=(Car)applicationContext.getBean("myBaoMa");
//        System.out.println(c1);
//        Car c2=(Car)applicationContext.getBean("myBYD");
//        System.out.println(c2);
//        Car c3=(Car)applicationContext.getBean("myNissan");
//        System.out.println(c3);
//
////        human.introduce();
//        Human h1=(Human)applicationContext.getBean("lisi");
//        Human h2=(Human)applicationContext.getBean("wangwu");
//        h1.introduce();
//        h2.introduce();



//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aop.xml");
//        MyMath myMath=(MyMath) applicationContext.getBean("m1");
//        myMath.setN1(3);
//        myMath.setN2(5);
//        myMath.add();
//        myMath.subtrace();
//        myMath.mul();
//        myMath.dev();
//        myMath.print();
//


//        MyMath t2=(MyMath) applicationContext.getBean("target2");
//        t2.add();
//        t2.getN1();
//        t2.mul();
//        t2.dev();





    }

}
