package personal.xjl.jerrymouse.spring;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Component("a1")
@Aspect
public class MyAnotherAdvice {
@Before("execution(* personal.xjl.jerrymouse.spring.MyMath.add(..))")
    public void before() throws Throwable{
        System.out.println("---前置增强---");
    }

@AfterReturning("execution(* personal.xjl.jerrymouse.spring.MyMath.subtrace(..))")
    public void afterReturning() throws Throwable{
        System.out.println("后置增强");
    }

@Around("execution(* personal.xjl.jerrymouse.spring.MyMath.mul(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("这是环绕增强的开始--------");
        Object object=joinPoint.proceed();
        System.out.println("环绕增强的结束------------");
        return object;
    }
    @Before("execution(* personal.xjl.jerrymouse.spring.MyMath.dev(..))")
    public void piyixia() throws Throwable{
        System.out.println("-----批一下增强-----");
    }
}
