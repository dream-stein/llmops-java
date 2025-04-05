package com.emcikem.llm.dao.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LlmOpsAppConfigDOExample {
    /**
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated
     */
    protected Integer offset;

    /**
     * @mbg.generated
     */
    protected Integer rows;

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        rows = null;
        offset = null;
    }

    /**
     *
     * @mbg.generated
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     *
     * @mbg.generated
     */
    public Integer getOffset() {
        return this.offset;
    }

    /**
     *
     * @mbg.generated
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     *
     * @mbg.generated
     */
    public Integer getRows() {
        return this.rows;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public static Criteria newAndCreateCriteria() {
        LlmOpsAppConfigDOExample example = new LlmOpsAppConfigDOExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsAppConfigDOExample distinct(boolean distinct) {
        this.setDistinct(distinct);
        return this;
    }

    /**
     *
     * @mbg.generated
     */
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andDialogRoundIsNull() {
            addCriterion("dialog_round is null");
            return (Criteria) this;
        }

        public Criteria andDialogRoundIsNotNull() {
            addCriterion("dialog_round is not null");
            return (Criteria) this;
        }

        public Criteria andDialogRoundEqualTo(Integer value) {
            addCriterion("dialog_round =", value, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundNotEqualTo(Integer value) {
            addCriterion("dialog_round <>", value, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundGreaterThan(Integer value) {
            addCriterion("dialog_round >", value, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundGreaterThanOrEqualTo(Integer value) {
            addCriterion("dialog_round >=", value, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundLessThan(Integer value) {
            addCriterion("dialog_round <", value, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundLessThanOrEqualTo(Integer value) {
            addCriterion("dialog_round <=", value, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundIn(List<Integer> values) {
            addCriterion("dialog_round in", values, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundNotIn(List<Integer> values) {
            addCriterion("dialog_round not in", values, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundBetween(Integer value1, Integer value2) {
            addCriterion("dialog_round between", value1, value2, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andDialogRoundNotBetween(Integer value1, Integer value2) {
            addCriterion("dialog_round not between", value1, value2, "dialogRound");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementIsNull() {
            addCriterion("opening_statement is null");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementIsNotNull() {
            addCriterion("opening_statement is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementEqualTo(String value) {
            addCriterion("opening_statement =", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementNotEqualTo(String value) {
            addCriterion("opening_statement <>", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementGreaterThan(String value) {
            addCriterion("opening_statement >", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementGreaterThanOrEqualTo(String value) {
            addCriterion("opening_statement >=", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementLessThan(String value) {
            addCriterion("opening_statement <", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementLessThanOrEqualTo(String value) {
            addCriterion("opening_statement <=", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementLike(String value) {
            addCriterion("opening_statement like", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementNotLike(String value) {
            addCriterion("opening_statement not like", value, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementIn(List<String> values) {
            addCriterion("opening_statement in", values, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementNotIn(List<String> values) {
            addCriterion("opening_statement not in", values, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementBetween(String value1, String value2) {
            addCriterion("opening_statement between", value1, value2, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andOpeningStatementNotBetween(String value1, String value2) {
            addCriterion("opening_statement not between", value1, value2, "openingStatement");
            return (Criteria) this;
        }

        public Criteria andConfigTypeIsNull() {
            addCriterion("config_type is null");
            return (Criteria) this;
        }

        public Criteria andConfigTypeIsNotNull() {
            addCriterion("config_type is not null");
            return (Criteria) this;
        }

        public Criteria andConfigTypeEqualTo(Boolean value) {
            addCriterion("config_type =", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotEqualTo(Boolean value) {
            addCriterion("config_type <>", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeGreaterThan(Boolean value) {
            addCriterion("config_type >", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("config_type >=", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLessThan(Boolean value) {
            addCriterion("config_type <", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("config_type <=", value, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeIn(List<Boolean> values) {
            addCriterion("config_type in", values, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotIn(List<Boolean> values) {
            addCriterion("config_type not in", values, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("config_type between", value1, value2, "configType");
            return (Criteria) this;
        }

        public Criteria andConfigTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("config_type not between", value1, value2, "configType");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }
    }

    /**
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         * @mbg.generated
         */
        private LlmOpsAppConfigDOExample example;

        /**
         *
         * @mbg.generated
         */
        protected Criteria(LlmOpsAppConfigDOExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated
         */
        public LlmOpsAppConfigDOExample example() {
            return this.example;
        }

        /**
         *
         * @mbg.generated
         */
        @Deprecated
        public Criteria andIf(boolean ifAdd, ICriteriaAdd add) {
            if (ifAdd) {
                add.add(this);
            }
            return this;
        }

        /**
         *
         * @mbg.generated
         */
        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        /**
         *
         * @mbg.generated
         */
        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        /**
         *
         * @mbg.generated
         */
        @Deprecated
        public interface ICriteriaAdd {
            /**
             *
             * @mbg.generated
             */
            Criteria add(Criteria add);
        }
    }

    /**
     *
     * @mbg.generated
     */
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

    /**
     *
     * @mbg.generated
     */
    public interface ICriteriaWhen {
        /**
         *
         * @mbg.generated
         */
        void criteria(Criteria criteria);
    }

    /**
     *
     * @mbg.generated
     */
    public interface IExampleWhen {
        /**
         *
         * @mbg.generated
         */
        void example(com.emcikem.llm.dao.example.LlmOpsAppConfigDOExample example);
    }
}