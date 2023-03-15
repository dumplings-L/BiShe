package personal.xjl.jerrymouse.mapper;


import org.apache.ibatis.annotations.*;
import personal.xjl.jerrymouse.entity.Student;

import java.util.List;

//springboot扫描包，生成数据库访问对象“studentMapper”
@Mapper
public interface StudentMapper {
    //查询
    @Select("select * from student")
    public List<Student> queryAll();
    //插入新纪录
    @Insert("insert into student(name,PASSWORD,sex,clazz,birthday) values(#{name},#{password},#{sex},#{clazz},#{birthday})")
    public int insert(Student student);
    //更新
   // @Update()
    //删除
  //  @Delete("")

}
