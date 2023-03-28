package personal.xjl.jerrymouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.xjl.jerrymouse.mapper.AdminMapper;

@Service
public class AdminServiceImpl {
    @Autowired
    AdminMapper adminMapper;
    public boolean login(String name,String password){
        if(adminMapper.selectByNameAndPassword(name, password).size()==0)
            return false;
        else
            return true;
    }
}
