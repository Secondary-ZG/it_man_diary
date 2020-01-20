package com.secondary.springaopjdk;

import com.secondary.springaopjdk.impl.ForumServiceImpl;

import java.lang.reflect.Proxy;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 15:47
 */
public class Test {

    public static void main(String[] args) {
        //希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();

        //将目标业务类和横切代码编织到一起
        PerformanceHandler handler = new PerformanceHandler(target);

        //根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        //调用代理实例
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }

}
