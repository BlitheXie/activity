package cn.activity.domain;

import java.util.Date;

public class UserSign {
    private Integer userId;

    private Integer activityId;

    private Date createTime;

    private Integer hasCheck;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHasCheck() {
        return hasCheck;
    }

    public void setHasCheck(Integer hasCheck) {
        this.hasCheck = hasCheck;
    }
}