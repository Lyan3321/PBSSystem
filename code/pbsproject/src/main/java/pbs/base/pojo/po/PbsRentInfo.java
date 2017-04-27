package pbs.base.pojo.po;

public class PbsRentInfo {
    private Integer id;

    private Integer rentId;

    private String zoneName;

    private String road;

    private String rentName;

    private String rentPosition;

    private Integer maxNumber;

    private Double lat;

    private Double lng;

    private String leftOrRight;

    private Integer rentRank;

    private Integer areaId;

    private Float topLimit;

    private Float lowLimit;

    private Double cLat;

    private Double cLng;

    private Integer operNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName == null ? null : zoneName.trim();
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road == null ? null : road.trim();
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName == null ? null : rentName.trim();
    }

    public String getRentPosition() {
        return rentPosition;
    }

    public void setRentPosition(String rentPosition) {
        this.rentPosition = rentPosition == null ? null : rentPosition.trim();
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getLeftOrRight() {
        return leftOrRight;
    }

    public void setLeftOrRight(String leftOrRight) {
        this.leftOrRight = leftOrRight == null ? null : leftOrRight.trim();
    }

    public Integer getRentRank() {
        return rentRank;
    }

    public void setRentRank(Integer rentRank) {
        this.rentRank = rentRank;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Float getTopLimit() {
        return topLimit;
    }

    public void setTopLimit(Float topLimit) {
        this.topLimit = topLimit;
    }

    public Float getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(Float lowLimit) {
        this.lowLimit = lowLimit;
    }

    public Double getcLat() {
        return cLat;
    }

    public void setcLat(Double cLat) {
        this.cLat = cLat;
    }

    public Double getcLng() {
        return cLng;
    }

    public void setcLng(Double cLng) {
        this.cLng = cLng;
    }

    public Integer getOperNum() {
        return operNum;
    }

    public void setOperNum(Integer operNum) {
        this.operNum = operNum;
    }
}