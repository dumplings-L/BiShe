package personal.xjl.jerrymouse.spring;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component("myCattle")
//全参构造
@AllArgsConstructor
//空参构造
@NoArgsConstructor
public class Cattle {
    @Value("niuNiu")
    private String name;
    @Value("300kg")
    private String weight;
}
