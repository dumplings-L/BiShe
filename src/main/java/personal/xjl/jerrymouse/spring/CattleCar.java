package personal.xjl.jerrymouse.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Data
@Component("myCattleCar")
//全参构造
@AllArgsConstructor
//空参构造
@NoArgsConstructor
public class CattleCar {

    @Value("erNiu")
    private String cattle;
    @Value("4")
    private String wheelNum;



}
