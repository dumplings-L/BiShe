package personal.xjl.jerrymouse.spring;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method,Object[] args,Object target) throws Throwable{
        System.out.println("---this is my before advice---");
    }
}
