package personal.xjl.jerrymouse.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import personal.xjl.jerrymouse.entity.Admin;

import java.util.Collection;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where username=#{name} and password=#{password}")
    Collection<Admin> selectByNameAndPassword(String name, String password);
}
