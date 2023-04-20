package personal.xjl.jerrymouse.spring;

import net.bytebuddy.implementation.bytecode.Throw;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyAdvice implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {




    @Override
    public void before(Method method,Object[] args,Object target) throws Throwable{
        System.out.println("---前置增强---");
    }

    @Override
    public void afterReturning(Object returnValue, Method method,Object[] args,Object target) throws Throwable{
        System.out.println("后置增强");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        System.out.println("这是环绕增强的开始--------");
        Object object=invocation.proceed();
        System.out.println("环绕增强的结束------------");
        return object;
    }
}
