package com.secondary.proxy;

import com.secondary.service.MaterialService;
import com.secondary.service.impl.MaterialServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 10:50
 * Description: CGLIB代理类
 */
@Slf4j
public class MaterialServiceCGLIBInterceptor implements MethodInterceptor {

    @Autowired
    private MaterialService materialService;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("[MaterialServiceCGLIBInterceptor] into [intercept] right now");
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }

    public static MaterialService createCGLIBMaterialProxy() {
        Enhancer enhancer = new Enhancer();

        //指定切入器，定义代理类逻辑
        enhancer.setCallback(new MaterialServiceCGLIBInterceptor());

        //指定实现的接口
        enhancer.setInterfaces(new Class[]{MaterialService.class});

        return (MaterialService) enhancer.create();
    }

}
