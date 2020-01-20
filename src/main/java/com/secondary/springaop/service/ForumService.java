package com.secondary.springaop.service;

import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;

/**
 * Java Class
 * Created By FeiYun
 * On 2020/1/17 17:23
 */
@Slf4j
public class ForumService {

    public void removeForum(int forumId) {
        log.info("do something");
        throw new RuntimeException("运行异常.");
    }

    public void updateForum(int forumId) throws Exception {
        log.info("do something");
        throw new SQLException("数据更新操作异常.");
    }

}
