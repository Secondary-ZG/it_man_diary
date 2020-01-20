package com.secondary.proxy;


import com.secondary.entity.Material;
import com.secondary.service.MaterialService;
import com.secondary.service.impl.MaterialServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 9:51
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MaterialServiceProxyTest {

    @Test
    public void MaterialProxyTest() throws Exception {
        Material material = new Material();
        MaterialService materialService = (MaterialService) Proxy.newProxyInstance(Material.class.getClassLoader(),
                new Class[]{Material.class}, new MaterialServiceProxy(new MaterialServiceImpl()));
        materialService.selectMaterials(material);
    }
}
