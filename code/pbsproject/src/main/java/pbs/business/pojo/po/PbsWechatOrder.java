package pbs.business.pojo.po;

import java.util.Date;

public class PbsWechatOrder {
    private Integer id;

    private Long orderId;

    private String openid;

    private String bikeId;

    private Integer startRent;

    private Integer endRent;

    private Integer startNode;

    private Integer endNode;

    private String startTime;

    private String endTime;

    private Integer totalTime;

    private Float money;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId == null ? null : bikeId.trim();
    }

    public Integer getStartRent() {
        return startRent;
    }

    public void setStartRent(Integer startRent) {
        this.startRent = startRent;
    }

    public Integer getEndRent() {
        return endRent;
    }

    public void setEndRent(Integer endRent) {
        this.endRent = endRent;
    }

    public Integer getStartNode() {
        return startNode;
    }

    public void setStartNode(Integer startNode) {
        this.startNode = startNode;
    }

    public Integer getEndNode() {
        return endNode;
    }

    public void setEndNode(Integer endNode) {
        this.endNode = endNode;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}