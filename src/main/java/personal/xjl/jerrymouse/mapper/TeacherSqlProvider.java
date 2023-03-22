package personal.xjl.jerrymouse.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import personal.xjl.jerrymouse.entity.Teacher;

public class TeacherSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    public String insertSelective(Teacher record) {
        BEGIN();
        INSERT_INTO("teacher");
        
        if (record.getId() != null) {
            VALUES("Id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("sex", "#{sex,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("birthday", "#{birthday,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseId() != null) {
            VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getProfessional() != null) {
            VALUES("professional", "#{professional,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table teacher
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(Teacher record) {
        BEGIN();
        UPDATE("teacher");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("sex = #{sex,jdbcType=INTEGER}");
        }
        
        if (record.getBirthday() != null) {
            SET("birthday = #{birthday,jdbcType=VARCHAR}");
        }
        
        if (record.getCourseId() != null) {
            SET("course_id = #{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getProfessional() != null) {
            SET("professional = #{professional,jdbcType=VARCHAR}");
        }
        
        WHERE("Id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}