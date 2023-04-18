package personal.xjl.jerrymouse.spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//@Component("zhangsan")
@Data
public class Human {
//    @Value("zhangsan")
    private String name;
//    @Autowired
//    @Qualifier("myBenz")
    private List<Car> cars;
    private Map<Integer,Human> relatives;

    public void introduce(){
        System.out.println("my name is"+name+",my car is "+cars+",my relatives is"+relatives);
    }
}
