package com.secondary.springaopcglib;

import com.secondary.springaopjdk.impl.ForumServiceImpl;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 16:25
 */
public class Test {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        //通过动态生成子类的方式创建代理类
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);

        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }

}
