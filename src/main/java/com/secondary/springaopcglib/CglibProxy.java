package com.secondary.springaopcglib;

import com.secondary.springaopjdk.PerfomanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 16:11
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    //拦截父类所有方法的调用
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerfomanceMonitor.begin(o.getClass().getName() + "." + method.getName());
        //通过代理类调用父类中的方法
        Object result = methodProxy.invokeSuper(o, objects);
        PerfomanceMonitor.end();
        return result;
    }
}
