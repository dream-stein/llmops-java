package com.emcikem.llm.dao.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LlmOpsChatHistoryDOExample {
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
    public LlmOpsChatHistoryDOExample() {
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
    public LlmOpsChatHistoryDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsChatHistoryDOExample orderBy(String ... orderByClauses) {
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
    public LlmOpsChatHistoryDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsChatHistoryDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsChatHistoryDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public static Criteria newAndCreateCriteria() {
        LlmOpsChatHistoryDOExample example = new LlmOpsChatHistoryDOExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsChatHistoryDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsChatHistoryDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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
    public LlmOpsChatHistoryDOExample distinct(boolean distinct) {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andDialogIdIsNull() {
            addCriterion("dialog_id is null");
            return (Criteria) this;
        }

        public Criteria andDialogIdIsNotNull() {
            addCriterion("dialog_id is not null");
            return (Criteria) this;
        }

        public Criteria andDialogIdEqualTo(Long value) {
            addCriterion("dialog_id =", value, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdNotEqualTo(Long value) {
            addCriterion("dialog_id <>", value, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdGreaterThan(Long value) {
            addCriterion("dialog_id >", value, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dialog_id >=", value, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdLessThan(Long value) {
            addCriterion("dialog_id <", value, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdLessThanOrEqualTo(Long value) {
            addCriterion("dialog_id <=", value, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdIn(List<Long> values) {
            addCriterion("dialog_id in", values, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdNotIn(List<Long> values) {
            addCriterion("dialog_id not in", values, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdBetween(Long value1, Long value2) {
            addCriterion("dialog_id between", value1, value2, "dialogId");
            return (Criteria) this;
        }

        public Criteria andDialogIdNotBetween(Long value1, Long value2) {
            addCriterion("dialog_id not between", value1, value2, "dialogId");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(Long value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(Long value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(Long value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(Long value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(Long value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(Long value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<Long> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<Long> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(Long value1, Long value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(Long value1, Long value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
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
        private LlmOpsChatHistoryDOExample example;

        /**
         *
         * @mbg.generated
         */
        protected Criteria(LlmOpsChatHistoryDOExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated
         */
        public LlmOpsChatHistoryDOExample example() {
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
        void example(com.emcikem.llm.dao.example.LlmOpsChatHistoryDOExample example);
    }
}