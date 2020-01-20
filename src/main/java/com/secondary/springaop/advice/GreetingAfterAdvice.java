package com.secondary.springaop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 16:57
 * Description:
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself");
    }
}
