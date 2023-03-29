package personal.xjl.jerrymouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {
    private int id;
    private String name;
    private String username;
    private String password;
}
