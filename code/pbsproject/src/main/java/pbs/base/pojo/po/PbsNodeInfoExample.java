package pbs.base.pojo.po;

import java.util.ArrayList;
import java.util.List;

public class PbsNodeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PbsNodeInfoExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Integer value) {
            addCriterion("node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Integer value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Integer value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Integer value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Integer> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Integer> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andBikeIdIsNull() {
            addCriterion("bike_id is null");
            return (Criteria) this;
        }

        public Criteria andBikeIdIsNotNull() {
            addCriterion("bike_id is not null");
            return (Criteria) this;
        }

        public Criteria andBikeIdEqualTo(String value) {
            addCriterion("bike_id =", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdNotEqualTo(String value) {
            addCriterion("bike_id <>", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdGreaterThan(String value) {
            addCriterion("bike_id >", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdGreaterThanOrEqualTo(String value) {
            addCriterion("bike_id >=", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdLessThan(String value) {
            addCriterion("bike_id <", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdLessThanOrEqualTo(String value) {
            addCriterion("bike_id <=", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdLike(String value) {
            addCriterion("bike_id like", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdNotLike(String value) {
            addCriterion("bike_id not like", value, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdIn(List<String> values) {
            addCriterion("bike_id in", values, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdNotIn(List<String> values) {
            addCriterion("bike_id not in", values, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdBetween(String value1, String value2) {
            addCriterion("bike_id between", value1, value2, "bikeId");
            return (Criteria) this;
        }

        public Criteria andBikeIdNotBetween(String value1, String value2) {
            addCriterion("bike_id not between", value1, value2, "bikeId");
            return (Criteria) this;
        }

        public Criteria andRentIdIsNull() {
            addCriterion("rent_id is null");
            return (Criteria) this;
        }

        public Criteria andRentIdIsNotNull() {
            addCriterion("rent_id is not null");
            return (Criteria) this;
        }

        public Criteria andRentIdEqualTo(Integer value) {
            addCriterion("rent_id =", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotEqualTo(Integer value) {
            addCriterion("rent_id <>", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThan(Integer value) {
            addCriterion("rent_id >", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_id >=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThan(Integer value) {
            addCriterion("rent_id <", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdLessThanOrEqualTo(Integer value) {
            addCriterion("rent_id <=", value, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdIn(List<Integer> values) {
            addCriterion("rent_id in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotIn(List<Integer> values) {
            addCriterion("rent_id not in", values, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdBetween(Integer value1, Integer value2) {
            addCriterion("rent_id between", value1, value2, "rentId");
            return (Criteria) this;
        }

        public Criteria andRentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_id not between", value1, value2, "rentId");
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