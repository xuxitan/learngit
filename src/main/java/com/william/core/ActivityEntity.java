package com.william.core;


import java.sql.Timestamp;

/**
 * 活动表-交互信息存贮
 *
 * @author xyd
 * @date 2017年11月15日 上午11:50:32
 */
public class ActivityEntity {

    private String activityId;//活动ID

    private String activityName;//活动名称

    private Integer activityNumber;//活动编号

    private Timestamp beginTime; //开始时间 

    private Timestamp endTime;//结束时间

    private String status;//活动状态(0 活动未开始1 活动进行中 2 活动已结束)

    private String activityChannel;//渠道(1.短信2.图片3.短信加图片)

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
        this.activityNumber = activityNumber;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityChannel() {
        return activityChannel;
    }

    public void setActivityChannel(String activityChannel) {
        this.activityChannel = activityChannel;
    }
}