package com.secondary.proxy;

import com.secondary.entity.Material;
import com.secondary.service.MaterialService;
import com.secondary.service.impl.MaterialServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 9:38
 */
@Slf4j
@Component
public class MaterialServiceProxy implements InvocationHandler {

    @Autowired
    private MaterialService materialService;

    public MaterialServiceProxy(MaterialService materialService) {
        this.materialService = materialService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("[MaterialServiceProxy] into [invoke] right now");
        method.invoke(materialService, args);
        log.info("[MaterialServiceProxy] out [invoke] right now");
        return null;
    }

    public static MaterialService createMaterialProxy() {
        log.info("[MaterialServiceProxy] into [createMaterialProxy] creating");
        MaterialService materialService = (MaterialService) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{MaterialService.class}, new MaterialServiceProxy(new MaterialServiceImpl()));
        return materialService;
    }

}
