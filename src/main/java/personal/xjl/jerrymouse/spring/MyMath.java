package personal.xjl.jerrymouse.spring;

import lombok.Data;
import org.springframework.stereotype.Component;

//@Data
@Component("m1")
public class MyMath {
    private int n1,n2,result;

    public void add(){
        result=n1+n2;
        System.out.println(result);
    }

    public void subtrace(){
        result=n1-n2;
        System.out.println(result);
    }

    public void mul(){
        result=n1*n2;
        System.out.println(result);
    }

    public void dev(){
        result=n1/n2;
        System.out.println();
    }

    public void print(){
        System.out.println(result);
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        System.out.println(n1);
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        System.out.println(n2);
        this.n2 = n2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
