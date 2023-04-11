package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.entity.Teacher;
import personal.xjl.jerrymouse.mapper.TeacherMapper;

import java.util.List;

@Service
public class TeacherServiceImpl {
    @Autowired
    TeacherMapper teacherMapper;
    //findAllTeachers
    public List<Teacher> findAllTeachers(){
        return teacherMapper.queryAll();
    }
    //addTeacher
    public int addTeacher(Teacher teacher){
        return teacherMapper.insert(teacher);
    }
    //login
    public boolean login(String name,String password){
        if (teacherMapper.selectByNameAndPassword(name,password).size()==0){
            return false;
        }else
            return true;
    }
    //删除老师
    public void removeStudent(int id) {
        teacherMapper.deleteByPrimaryKey(id);
    }

    public Teacher selectUpdateTeacher(int id){
        return teacherMapper.selectByPrimaryKey(id);
    }

    public int UpdateTeacher(Teacher newTeacher){
        return teacherMapper.updateByPrimaryKey(newTeacher);
    }
}
