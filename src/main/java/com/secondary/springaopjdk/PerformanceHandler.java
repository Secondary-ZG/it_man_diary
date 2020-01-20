package com.secondary.springaopjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 15:52
 * Description:
 */
public class PerformanceHandler implements InvocationHandler {

    //target为目标的业务类
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerfomanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        //通过反射方法调用业务类的目标方法
        Object obj = method.invoke(target, args);
        PerfomanceMonitor.end();
        return obj;
    }
}
