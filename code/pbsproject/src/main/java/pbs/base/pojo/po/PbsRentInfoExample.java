package pbs.base.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class PbsRentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PbsRentInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRentIdIsNull() {
            addCriterion("RENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andRentIdIsNotNull() {
            addCriterion("RENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRentIdEqualTo(Integer value) {
            addCriterion("RENT_ID =", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotEqualTo(Integer value) {
            addCriterion("RENT_ID <>", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThan(Integer value) {
            addCriterion("RENT_ID >", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RENT_ID >=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThan(Integer value) {
            addCriterion("RENT_ID <", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThanOrEqualTo(Integer value) {
            addCriterion("RENT_ID <=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdIn(List<Integer> values) {
            addCriterion("RENT_ID in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotIn(List<Integer> values) {
            addCriterion("RENT_ID not in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdBetween(Integer value1, Integer value2) {
            addCriterion("RENT_ID between", value1, value2, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RENT_ID not between", value1, value2, "rentId");
            return (Criteria) this;
        }

        public Criteria andZoneNameIsNull() {
            addCriterion("ZONE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andZoneNameIsNotNull() {
            addCriterion("ZONE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andZoneNameEqualTo(String value) {
            addCriterion("ZONE_NAME =", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameNotEqualTo(String value) {
            addCriterion("ZONE_NAME <>", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameGreaterThan(String value) {
            addCriterion("ZONE_NAME >", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameGreaterThanOrEqualTo(String value) {
            addCriterion("ZONE_NAME >=", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameLessThan(String value) {
            addCriterion("ZONE_NAME <", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameLessThanOrEqualTo(String value) {
            addCriterion("ZONE_NAME <=", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameLike(String value) {
            addCriterion("ZONE_NAME like", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameNotLike(String value) {
            addCriterion("ZONE_NAME not like", value, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameIn(List<String> values) {
            addCriterion("ZONE_NAME in", values, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameNotIn(List<String> values) {
            addCriterion("ZONE_NAME not in", values, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameBetween(String value1, String value2) {
            addCriterion("ZONE_NAME between", value1, value2, "zoneName");
            return (Criteria) this;
        }

        public Criteria andZoneNameNotBetween(String value1, String value2) {
            addCriterion("ZONE_NAME not between", value1, value2, "zoneName");
            return (Criteria) this;
        }

        public Criteria andRoadIsNull() {
            addCriterion("ROAD is null");
            return (Criteria) this;
        }

        public Criteria andRoadIsNotNull() {
            addCriterion("ROAD is not null");
            return (Criteria) this;
        }

        public Criteria andRoadEqualTo(String value) {
            addCriterion("ROAD =", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotEqualTo(String value) {
            addCriterion("ROAD <>", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadGreaterThan(String value) {
            addCriterion("ROAD >", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadGreaterThanOrEqualTo(String value) {
            addCriterion("ROAD >=", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadLessThan(String value) {
            addCriterion("ROAD <", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadLessThanOrEqualTo(String value) {
            addCriterion("ROAD <=", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadLike(String value) {
            addCriterion("ROAD like", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotLike(String value) {
            addCriterion("ROAD not like", value, "road");
            return (Criteria) this;
        }

        public Criteria andRoadIn(List<String> values) {
            addCriterion("ROAD in", values, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotIn(List<String> values) {
            addCriterion("ROAD not in", values, "road");
            return (Criteria) this;
        }

        public Criteria andRoadBetween(String value1, String value2) {
            addCriterion("ROAD between", value1, value2, "road");
            return (Criteria) this;
        }

        public Criteria andRoadNotBetween(String value1, String value2) {
            addCriterion("ROAD not between", value1, value2, "road");
            return (Criteria) this;
        }

        public Criteria andRentNameIsNull() {
            addCriterion("RENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRentNameIsNotNull() {
            addCriterion("RENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRentNameEqualTo(String value) {
            addCriterion("RENT_NAME =", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameNotEqualTo(String value) {
            addCriterion("RENT_NAME <>", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameGreaterThan(String value) {
            addCriterion("RENT_NAME >", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameGreaterThanOrEqualTo(String value) {
            addCriterion("RENT_NAME >=", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameLessThan(String value) {
            addCriterion("RENT_NAME <", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameLessThanOrEqualTo(String value) {
            addCriterion("RENT_NAME <=", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameLike(String value) {
            addCriterion("RENT_NAME like", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameNotLike(String value) {
            addCriterion("RENT_NAME not like", value, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameIn(List<String> values) {
            addCriterion("RENT_NAME in", values, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameNotIn(List<String> values) {
            addCriterion("RENT_NAME not in", values, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameBetween(String value1, String value2) {
            addCriterion("RENT_NAME between", value1, value2, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentNameNotBetween(String value1, String value2) {
            addCriterion("RENT_NAME not between", value1, value2, "rentName");
            return (Criteria) this;
        }

        public Criteria andRentPositionIsNull() {
            addCriterion("RENT_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andRentPositionIsNotNull() {
            addCriterion("RENT_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andRentPositionEqualTo(String value) {
            addCriterion("RENT_POSITION =", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionNotEqualTo(String value) {
            addCriterion("RENT_POSITION <>", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionGreaterThan(String value) {
            addCriterion("RENT_POSITION >", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionGreaterThanOrEqualTo(String value) {
            addCriterion("RENT_POSITION >=", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionLessThan(String value) {
            addCriterion("RENT_POSITION <", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionLessThanOrEqualTo(String value) {
            addCriterion("RENT_POSITION <=", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionLike(String value) {
            addCriterion("RENT_POSITION like", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionNotLike(String value) {
            addCriterion("RENT_POSITION not like", value, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionIn(List<String> values) {
            addCriterion("RENT_POSITION in", values, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionNotIn(List<String> values) {
            addCriterion("RENT_POSITION not in", values, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionBetween(String value1, String value2) {
            addCriterion("RENT_POSITION between", value1, value2, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andRentPositionNotBetween(String value1, String value2) {
            addCriterion("RENT_POSITION not between", value1, value2, "rentPosition");
            return (Criteria) this;
        }

        public Criteria andMaxNumberIsNull() {
            addCriterion("MAX_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumberIsNotNull() {
            addCriterion("MAX_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumberEqualTo(Integer value) {
            addCriterion("MAX_NUMBER =", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberNotEqualTo(Integer value) {
            addCriterion("MAX_NUMBER <>", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberGreaterThan(Integer value) {
            addCriterion("MAX_NUMBER >", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_NUMBER >=", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberLessThan(Integer value) {
            addCriterion("MAX_NUMBER <", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_NUMBER <=", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberIn(List<Integer> values) {
            addCriterion("MAX_NUMBER in", values, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberNotIn(List<Integer> values) {
            addCriterion("MAX_NUMBER not in", values, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberBetween(Integer value1, Integer value2) {
            addCriterion("MAX_NUMBER between", value1, value2, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_NUMBER not between", value1, value2, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("LAT is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("LAT is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("LAT =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("LAT <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("LAT >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("LAT >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("LAT <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("LAT <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("LAT in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("LAT not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("LAT between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("LAT not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("LNG is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("LNG is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("LNG =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("LNG <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("LNG >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("LNG >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("LNG <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("LNG <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("LNG in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("LNG not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("LNG between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("LNG not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightIsNull() {
            addCriterion("LEFT_OR_RIGHT is null");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightIsNotNull() {
            addCriterion("LEFT_OR_RIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightEqualTo(String value) {
            addCriterion("LEFT_OR_RIGHT =", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightNotEqualTo(String value) {
            addCriterion("LEFT_OR_RIGHT <>", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightGreaterThan(String value) {
            addCriterion("LEFT_OR_RIGHT >", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightGreaterThanOrEqualTo(String value) {
            addCriterion("LEFT_OR_RIGHT >=", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightLessThan(String value) {
            addCriterion("LEFT_OR_RIGHT <", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightLessThanOrEqualTo(String value) {
            addCriterion("LEFT_OR_RIGHT <=", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightLike(String value) {
            addCriterion("LEFT_OR_RIGHT like", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightNotLike(String value) {
            addCriterion("LEFT_OR_RIGHT not like", value, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightIn(List<String> values) {
            addCriterion("LEFT_OR_RIGHT in", values, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightNotIn(List<String> values) {
            addCriterion("LEFT_OR_RIGHT not in", values, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightBetween(String value1, String value2) {
            addCriterion("LEFT_OR_RIGHT between", value1, value2, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andLeftOrRightNotBetween(String value1, String value2) {
            addCriterion("LEFT_OR_RIGHT not between", value1, value2, "leftOrRight");
            return (Criteria) this;
        }

        public Criteria andRentRankIsNull() {
            addCriterion("RENT_RANK is null");
            return (Criteria) this;
        }

        public Criteria andRentRankIsNotNull() {
            addCriterion("RENT_RANK is not null");
            return (Criteria) this;
        }

        public Criteria andRentRankEqualTo(Integer value) {
            addCriterion("RENT_RANK =", value, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankNotEqualTo(Integer value) {
            addCriterion("RENT_RANK <>", value, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankGreaterThan(Integer value) {
            addCriterion("RENT_RANK >", value, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("RENT_RANK >=", value, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankLessThan(Integer value) {
            addCriterion("RENT_RANK <", value, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankLessThanOrEqualTo(Integer value) {
            addCriterion("RENT_RANK <=", value, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankIn(List<Integer> values) {
            addCriterion("RENT_RANK in", values, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankNotIn(List<Integer> values) {
            addCriterion("RENT_RANK not in", values, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankBetween(Integer value1, Integer value2) {
            addCriterion("RENT_RANK between", value1, value2, "rentRank");
            return (Criteria) this;
        }

        public Criteria andRentRankNotBetween(Integer value1, Integer value2) {
            addCriterion("RENT_RANK not between", value1, value2, "rentRank");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("AREA_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("AREA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("AREA_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("AREA_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("AREA_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AREA_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("AREA_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("AREA_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("AREA_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("AREA_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("AREA_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AREA_ID not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andTopLimitIsNull() {
            addCriterion("TOP_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andTopLimitIsNotNull() {
            addCriterion("TOP_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andTopLimitEqualTo(Float value) {
            addCriterion("TOP_LIMIT =", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitNotEqualTo(Float value) {
            addCriterion("TOP_LIMIT <>", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitGreaterThan(Float value) {
            addCriterion("TOP_LIMIT >", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitGreaterThanOrEqualTo(Float value) {
            addCriterion("TOP_LIMIT >=", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitLessThan(Float value) {
            addCriterion("TOP_LIMIT <", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitLessThanOrEqualTo(Float value) {
            addCriterion("TOP_LIMIT <=", value, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitIn(List<Float> values) {
            addCriterion("TOP_LIMIT in", values, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitNotIn(List<Float> values) {
            addCriterion("TOP_LIMIT not in", values, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitBetween(Float value1, Float value2) {
            addCriterion("TOP_LIMIT between", value1, value2, "topLimit");
            return (Criteria) this;
        }

        public Criteria andTopLimitNotBetween(Float value1, Float value2) {
            addCriterion("TOP_LIMIT not between", value1, value2, "topLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitIsNull() {
            addCriterion("LOW_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andLowLimitIsNotNull() {
            addCriterion("LOW_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andLowLimitEqualTo(Float value) {
            addCriterion("LOW_LIMIT =", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitNotEqualTo(Float value) {
            addCriterion("LOW_LIMIT <>", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitGreaterThan(Float value) {
            addCriterion("LOW_LIMIT >", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitGreaterThanOrEqualTo(Float value) {
            addCriterion("LOW_LIMIT >=", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitLessThan(Float value) {
            addCriterion("LOW_LIMIT <", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitLessThanOrEqualTo(Float value) {
            addCriterion("LOW_LIMIT <=", value, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitIn(List<Float> values) {
            addCriterion("LOW_LIMIT in", values, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitNotIn(List<Float> values) {
            addCriterion("LOW_LIMIT not in", values, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitBetween(Float value1, Float value2) {
            addCriterion("LOW_LIMIT between", value1, value2, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andLowLimitNotBetween(Float value1, Float value2) {
            addCriterion("LOW_LIMIT not between", value1, value2, "lowLimit");
            return (Criteria) this;
        }

        public Criteria andCLatIsNull() {
            addCriterion("C_LAT is null");
            return (Criteria) this;
        }

        public Criteria andCLatIsNotNull() {
            addCriterion("C_LAT is not null");
            return (Criteria) this;
        }

        public Criteria andCLatEqualTo(Double value) {
            addCriterion("C_LAT =", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatNotEqualTo(Double value) {
            addCriterion("C_LAT <>", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatGreaterThan(Double value) {
            addCriterion("C_LAT >", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatGreaterThanOrEqualTo(Double value) {
            addCriterion("C_LAT >=", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatLessThan(Double value) {
            addCriterion("C_LAT <", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatLessThanOrEqualTo(Double value) {
            addCriterion("C_LAT <=", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatIn(List<Double> values) {
            addCriterion("C_LAT in", values, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatNotIn(List<Double> values) {
            addCriterion("C_LAT not in", values, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatBetween(Double value1, Double value2) {
            addCriterion("C_LAT between", value1, value2, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatNotBetween(Double value1, Double value2) {
            addCriterion("C_LAT not between", value1, value2, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLngIsNull() {
            addCriterion("C_LNG is null");
            return (Criteria) this;
        }

        public Criteria andCLngIsNotNull() {
            addCriterion("C_LNG is not null");
            return (Criteria) this;
        }

        public Criteria andCLngEqualTo(Double value) {
            addCriterion("C_LNG =", value, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngNotEqualTo(Double value) {
            addCriterion("C_LNG <>", value, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngGreaterThan(Double value) {
            addCriterion("C_LNG >", value, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngGreaterThanOrEqualTo(Double value) {
            addCriterion("C_LNG >=", value, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngLessThan(Double value) {
            addCriterion("C_LNG <", value, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngLessThanOrEqualTo(Double value) {
            addCriterion("C_LNG <=", value, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngIn(List<Double> values) {
            addCriterion("C_LNG in", values, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngNotIn(List<Double> values) {
            addCriterion("C_LNG not in", values, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngBetween(Double value1, Double value2) {
            addCriterion("C_LNG between", value1, value2, "cLng");
            return (Criteria) this;
        }

        public Criteria andCLngNotBetween(Double value1, Double value2) {
            addCriterion("C_LNG not between", value1, value2, "cLng");
            return (Criteria) this;
        }

        public Criteria andOperNumIsNull() {
            addCriterion("OPER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andOperNumIsNotNull() {
            addCriterion("OPER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andOperNumEqualTo(Integer value) {
            addCriterion("OPER_NUM =", value, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumNotEqualTo(Integer value) {
            addCriterion("OPER_NUM <>", value, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumGreaterThan(Integer value) {
            addCriterion("OPER_NUM >", value, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPER_NUM >=", value, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumLessThan(Integer value) {
            addCriterion("OPER_NUM <", value, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumLessThanOrEqualTo(Integer value) {
            addCriterion("OPER_NUM <=", value, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumIn(List<Integer> values) {
            addCriterion("OPER_NUM in", values, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumNotIn(List<Integer> values) {
            addCriterion("OPER_NUM not in", values, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumBetween(Integer value1, Integer value2) {
            addCriterion("OPER_NUM between", value1, value2, "operNum");
            return (Criteria) this;
        }

        public Criteria andOperNumNotBetween(Integer value1, Integer value2) {
            addCriterion("OPER_NUM not between", value1, value2, "operNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}