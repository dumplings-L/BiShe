package personal.xjl.jerrymouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//无参构造函数
@NoArgsConstructor
//全参构造函数
@AllArgsConstructor
@Data
public class Student {
    private int id;
    private String name;
    private String password;
    private int sex;
    private String clazz;
    private String birthday;

}
