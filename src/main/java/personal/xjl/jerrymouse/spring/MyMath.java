package personal.xjl.jerrymouse.spring;

import lombok.Data;

@Data
public class MyMath {
    private int n1,n2,result;

    public int add(){
        return result=n1+n2;
    }

    public int subtrace(){
        return result=n1-n2;
    }

    public int mul(){
        return result=n1*n2;
    }

    public int dev(){
        return result=n1/n2;
    }

    public void print(){
        System.out.println(result);
    }

}
