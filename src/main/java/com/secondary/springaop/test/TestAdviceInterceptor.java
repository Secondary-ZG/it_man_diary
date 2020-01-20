package com.secondary.springaop.test;

import com.secondary.springaop.Waiter;
import com.secondary.springaop.advice.GreetingInterceptor;
import com.secondary.springaop.impl.NativeWaiter;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 17:34
 */
public class TestAdviceInterceptor {

    public static void main(String[] args) {
        Waiter target = new NativeWaiter();

        //环绕增强
        MethodInterceptor greetingInterceptor = new GreetingInterceptor();

        //Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //指定针对接口代理
        pf.setInterfaces(target.getClass().getInterfaces());
        //启用优化
        pf.setOptimize(true);

        //设置代理目标
        pf.setTarget(target);

        //为代理目标类添加环绕增强
        pf.addAdvice(greetingInterceptor);

        //生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

}
