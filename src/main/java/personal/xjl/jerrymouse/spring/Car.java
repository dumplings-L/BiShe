package personal.xjl.jerrymouse.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myBenz")
@Data
//全参构造函数
@AllArgsConstructor
//空参构造函数
@NoArgsConstructor
public class Car {

    @Value("Benz")
    private String brand;
    @Value("E300")
    private String type;
    @Value("360")
    private int maxSpeed;
}
