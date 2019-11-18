package com.secondary.common;

import java.util.Date;

/**
 * Java Class
 * Created By Secondary
 * On 2019/11/5 14:51
 * Description: 基础类
 */
public class BaseEntity {

    /** 创建时间 **/
    private Date createTime;

    /** 修改时间 **/
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
