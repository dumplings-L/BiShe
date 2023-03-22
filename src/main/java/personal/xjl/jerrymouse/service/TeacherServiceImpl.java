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
}
