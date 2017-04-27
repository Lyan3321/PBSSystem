package pbs.base.pojo.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PbsBikeInfo {
    private Long id;

    private String bikeId;

    private String proDate;

    private String factory;

    private Integer state;

    private Integer dynamicState;

    private Integer rentId;

    private Integer nodeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId == null ? null : bikeId.trim();
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDynamicState() {
        return dynamicState;
    }

    public void setDynamicState(Integer dynamicState) {
        this.dynamicState = dynamicState;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }
}