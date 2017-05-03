package pbs.business.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PbsWechatOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PbsWechatOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andStartRentIsNull() {
            addCriterion("Start_rent is null");
            return (Criteria) this;
        }

        public Criteria andStartRentIsNotNull() {
            addCriterion("Start_rent is not null");
            return (Criteria) this;
        }

        public Criteria andStartRentEqualTo(Integer value) {
            addCriterion("Start_rent =", value, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentNotEqualTo(Integer value) {
            addCriterion("Start_rent <>", value, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentGreaterThan(Integer value) {
            addCriterion("Start_rent >", value, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentGreaterThanOrEqualTo(Integer value) {
            addCriterion("Start_rent >=", value, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentLessThan(Integer value) {
            addCriterion("Start_rent <", value, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentLessThanOrEqualTo(Integer value) {
            addCriterion("Start_rent <=", value, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentIn(List<Integer> values) {
            addCriterion("Start_rent in", values, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentNotIn(List<Integer> values) {
            addCriterion("Start_rent not in", values, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentBetween(Integer value1, Integer value2) {
            addCriterion("Start_rent between", value1, value2, "startRent");
            return (Criteria) this;
        }

        public Criteria andStartRentNotBetween(Integer value1, Integer value2) {
            addCriterion("Start_rent not between", value1, value2, "startRent");
            return (Criteria) this;
        }

        public Criteria andEndRentIsNull() {
            addCriterion("End_rent is null");
            return (Criteria) this;
        }

        public Criteria andEndRentIsNotNull() {
            addCriterion("End_rent is not null");
            return (Criteria) this;
        }

        public Criteria andEndRentEqualTo(Integer value) {
            addCriterion("End_rent =", value, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentNotEqualTo(Integer value) {
            addCriterion("End_rent <>", value, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentGreaterThan(Integer value) {
            addCriterion("End_rent >", value, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentGreaterThanOrEqualTo(Integer value) {
            addCriterion("End_rent >=", value, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentLessThan(Integer value) {
            addCriterion("End_rent <", value, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentLessThanOrEqualTo(Integer value) {
            addCriterion("End_rent <=", value, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentIn(List<Integer> values) {
            addCriterion("End_rent in", values, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentNotIn(List<Integer> values) {
            addCriterion("End_rent not in", values, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentBetween(Integer value1, Integer value2) {
            addCriterion("End_rent between", value1, value2, "endRent");
            return (Criteria) this;
        }

        public Criteria andEndRentNotBetween(Integer value1, Integer value2) {
            addCriterion("End_rent not between", value1, value2, "endRent");
            return (Criteria) this;
        }

        public Criteria andStartNodeIsNull() {
            addCriterion("Start_node is null");
            return (Criteria) this;
        }

        public Criteria andStartNodeIsNotNull() {
            addCriterion("Start_node is not null");
            return (Criteria) this;
        }

        public Criteria andStartNodeEqualTo(Integer value) {
            addCriterion("Start_node =", value, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeNotEqualTo(Integer value) {
            addCriterion("Start_node <>", value, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeGreaterThan(Integer value) {
            addCriterion("Start_node >", value, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Start_node >=", value, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeLessThan(Integer value) {
            addCriterion("Start_node <", value, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeLessThanOrEqualTo(Integer value) {
            addCriterion("Start_node <=", value, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeIn(List<Integer> values) {
            addCriterion("Start_node in", values, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeNotIn(List<Integer> values) {
            addCriterion("Start_node not in", values, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeBetween(Integer value1, Integer value2) {
            addCriterion("Start_node between", value1, value2, "startNode");
            return (Criteria) this;
        }

        public Criteria andStartNodeNotBetween(Integer value1, Integer value2) {
            addCriterion("Start_node not between", value1, value2, "startNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeIsNull() {
            addCriterion("End_node is null");
            return (Criteria) this;
        }

        public Criteria andEndNodeIsNotNull() {
            addCriterion("End_node is not null");
            return (Criteria) this;
        }

        public Criteria andEndNodeEqualTo(Integer value) {
            addCriterion("End_node =", value, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeNotEqualTo(Integer value) {
            addCriterion("End_node <>", value, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeGreaterThan(Integer value) {
            addCriterion("End_node >", value, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("End_node >=", value, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeLessThan(Integer value) {
            addCriterion("End_node <", value, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeLessThanOrEqualTo(Integer value) {
            addCriterion("End_node <=", value, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeIn(List<Integer> values) {
            addCriterion("End_node in", values, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeNotIn(List<Integer> values) {
            addCriterion("End_node not in", values, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeBetween(Integer value1, Integer value2) {
            addCriterion("End_node between", value1, value2, "endNode");
            return (Criteria) this;
        }

        public Criteria andEndNodeNotBetween(Integer value1, Integer value2) {
            addCriterion("End_node not between", value1, value2, "endNode");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("Start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("Start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("Start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("Start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("Start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("Start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("Start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("Start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("Start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("Start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("Start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("Start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("End_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("End_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("End_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("End_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("End_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("End_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("End_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("End_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("End_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("End_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("End_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("End_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("Money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("Money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Float value) {
            addCriterion("Money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Float value) {
            addCriterion("Money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Float value) {
            addCriterion("Money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("Money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Float value) {
            addCriterion("Money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Float value) {
            addCriterion("Money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Float> values) {
            addCriterion("Money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Float> values) {
            addCriterion("Money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Float value1, Float value2) {
            addCriterion("Money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Float value1, Float value2) {
            addCriterion("Money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("State is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("State is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("State =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("State <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("State >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("State >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("State <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("State <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("State in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("State not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("State between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("State not between", value1, value2, "state");
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