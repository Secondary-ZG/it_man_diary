package com.secondary.springaop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 16:37
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        //在目标类方法调用前执行
        String clientName = (String) objects[0];
        System.out.println("How are you ! Mr." + clientName + ".");
    }
}
