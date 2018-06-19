package cn.activity.domain;

import java.util.Date;

public class Activity {
    private Integer id;

    private Integer view;

    private String head;

    private String activityName;

    private byte[] activityContent;

    private Date createTime;

    private Integer mustCheck;

    private Date endTime;

    private Date startTime;

    private Integer origanizationId;

    private String organizationName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public byte[] getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(byte[] activityContent) {
        this.activityContent = activityContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getMustCheck() {
        return mustCheck;
    }

    public void setMustCheck(Integer mustCheck) {
        this.mustCheck = mustCheck;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getOriganizationId() {
        return origanizationId;
    }

    public void setOriganizationId(Integer origanizationId) {
        this.origanizationId = origanizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }
}