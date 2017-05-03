package pbs.business.pojo.po;

import java.util.Date;

public class PbsWechatOrder {
    private Integer id;

    private Long orderId;

    private String openid;

    private Integer startRent;

    private Integer endRent;

    private Integer startNode;

    private Integer endNode;

    private String startTime;

    private String endTime;

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

    public void setStartTime(String string) {
        this.startTime = string;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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