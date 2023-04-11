package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.entity.Student;
import personal.xjl.jerrymouse.mapper.StudentMapper;

import java.util.List;

//springboot启动时，自动扫描生成一个业务对象，对象名"studentServiceImpl"
@Service
public class StudentServiceImpl {
    @Autowired
    StudentMapper studentMapper;
    //查询所有学生
    public List<Student>  findAllStudents(){
        return studentMapper.queryAll();
    }
    //增加学生
    public void addStudent(Student student){
        studentMapper.insert(student);
    }

    //登录
    public boolean login(String name,String password){
        if(studentMapper.selectByNameAndPassword(name, password).size()==0)
            return false;
        else
            return true;
    }

    //删除学生
    public void removeStudent(int id) {
        studentMapper.deleteByPrimaryKey(id);
    }
    //修改学生

    public Student selectStudentById(int id){
        return studentMapper.selectByPrimaryKey(id);
    }
    public int UpdateStudent(Student newStudent){
        return studentMapper.updateByPrimaryKey(newStudent);
    }

}
