package com.secondary.springaopjdk.impl;

import com.secondary.springaopjdk.ForumService;
import lombok.extern.slf4j.Slf4j;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 13:35
 */
@Slf4j
public class ForumServiceImpl implements ForumService {

    @Override
    public void removeTopic(int topicId) {
//        PerfomanceMonitor.begin("com.secondary.springaopjdk.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除记录" + topicId);
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            log.error("[ForumServiceImpl][removeTopic] is error:", e);
        }

//        PerfomanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
//        PerfomanceMonitor.begin("com.secondary.springaopjdk.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.sleep(40);
        } catch (Exception e) {
            log.error("[ForumServiceImpl][removeForum] is error:", e);
        }

//        PerfomanceMonitor.end();
    }
}
