package com.secondary.springaop.test;

import com.secondary.springaop.manager.TransactionManager;
import com.secondary.springaop.service.ForumService;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 17:35
 */
public class TestThrowingAdvice {

    public static void main(String[] args) throws Exception {

        ForumService forumService = new ForumService();

        ThrowsAdvice transactionManager  = new TransactionManager();

        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(transactionManager);

        pf.setTarget(forumService);

        pf.setProxyTargetClass(true);

        ForumService proxy = (ForumService) pf.getProxy();

        proxy.removeForum(10);
        proxy.updateForum(10);

    }

}
