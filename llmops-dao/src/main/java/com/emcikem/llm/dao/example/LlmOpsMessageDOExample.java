package com.emcikem.llm.dao.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LlmOpsMessageDOExample {
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
    public LlmOpsMessageDOExample() {
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
    public LlmOpsMessageDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsMessageDOExample orderBy(String ... orderByClauses) {
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
    public LlmOpsMessageDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsMessageDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsMessageDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public static Criteria newAndCreateCriteria() {
        LlmOpsMessageDOExample example = new LlmOpsMessageDOExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsMessageDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsMessageDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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
    public LlmOpsMessageDOExample distinct(boolean distinct) {
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

        public Criteria andConversationIsNull() {
            addCriterion("conversation is null");
            return (Criteria) this;
        }

        public Criteria andConversationIsNotNull() {
            addCriterion("conversation is not null");
            return (Criteria) this;
        }

        public Criteria andConversationEqualTo(String value) {
            addCriterion("conversation =", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationNotEqualTo(String value) {
            addCriterion("conversation <>", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationGreaterThan(String value) {
            addCriterion("conversation >", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationGreaterThanOrEqualTo(String value) {
            addCriterion("conversation >=", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationLessThan(String value) {
            addCriterion("conversation <", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationLessThanOrEqualTo(String value) {
            addCriterion("conversation <=", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationLike(String value) {
            addCriterion("conversation like", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationNotLike(String value) {
            addCriterion("conversation not like", value, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationIn(List<String> values) {
            addCriterion("conversation in", values, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationNotIn(List<String> values) {
            addCriterion("conversation not in", values, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationBetween(String value1, String value2) {
            addCriterion("conversation between", value1, value2, "conversation");
            return (Criteria) this;
        }

        public Criteria andConversationNotBetween(String value1, String value2) {
            addCriterion("conversation not between", value1, value2, "conversation");
            return (Criteria) this;
        }

        public Criteria andInvokeFromIsNull() {
            addCriterion("invoke_from is null");
            return (Criteria) this;
        }

        public Criteria andInvokeFromIsNotNull() {
            addCriterion("invoke_from is not null");
            return (Criteria) this;
        }

        public Criteria andInvokeFromEqualTo(String value) {
            addCriterion("invoke_from =", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromNotEqualTo(String value) {
            addCriterion("invoke_from <>", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromGreaterThan(String value) {
            addCriterion("invoke_from >", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromGreaterThanOrEqualTo(String value) {
            addCriterion("invoke_from >=", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromLessThan(String value) {
            addCriterion("invoke_from <", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromLessThanOrEqualTo(String value) {
            addCriterion("invoke_from <=", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromLike(String value) {
            addCriterion("invoke_from like", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromNotLike(String value) {
            addCriterion("invoke_from not like", value, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromIn(List<String> values) {
            addCriterion("invoke_from in", values, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromNotIn(List<String> values) {
            addCriterion("invoke_from not in", values, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromBetween(String value1, String value2) {
            addCriterion("invoke_from between", value1, value2, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andInvokeFromNotBetween(String value1, String value2) {
            addCriterion("invoke_from not between", value1, value2, "invokeFrom");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountIsNull() {
            addCriterion("message_token_count is null");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountIsNotNull() {
            addCriterion("message_token_count is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountEqualTo(Integer value) {
            addCriterion("message_token_count =", value, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountNotEqualTo(Integer value) {
            addCriterion("message_token_count <>", value, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountGreaterThan(Integer value) {
            addCriterion("message_token_count >", value, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_token_count >=", value, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountLessThan(Integer value) {
            addCriterion("message_token_count <", value, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountLessThanOrEqualTo(Integer value) {
            addCriterion("message_token_count <=", value, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountIn(List<Integer> values) {
            addCriterion("message_token_count in", values, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountNotIn(List<Integer> values) {
            addCriterion("message_token_count not in", values, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountBetween(Integer value1, Integer value2) {
            addCriterion("message_token_count between", value1, value2, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageTokenCountNotBetween(Integer value1, Integer value2) {
            addCriterion("message_token_count not between", value1, value2, "messageTokenCount");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceIsNull() {
            addCriterion("message_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceIsNotNull() {
            addCriterion("message_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceEqualTo(Float value) {
            addCriterion("message_unit_price =", value, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceNotEqualTo(Float value) {
            addCriterion("message_unit_price <>", value, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceGreaterThan(Float value) {
            addCriterion("message_unit_price >", value, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("message_unit_price >=", value, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceLessThan(Float value) {
            addCriterion("message_unit_price <", value, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceLessThanOrEqualTo(Float value) {
            addCriterion("message_unit_price <=", value, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceIn(List<Float> values) {
            addCriterion("message_unit_price in", values, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceNotIn(List<Float> values) {
            addCriterion("message_unit_price not in", values, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceBetween(Float value1, Float value2) {
            addCriterion("message_unit_price between", value1, value2, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessageUnitPriceNotBetween(Float value1, Float value2) {
            addCriterion("message_unit_price not between", value1, value2, "messageUnitPrice");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitIsNull() {
            addCriterion("message_price_unit is null");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitIsNotNull() {
            addCriterion("message_price_unit is not null");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitEqualTo(Float value) {
            addCriterion("message_price_unit =", value, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitNotEqualTo(Float value) {
            addCriterion("message_price_unit <>", value, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitGreaterThan(Float value) {
            addCriterion("message_price_unit >", value, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitGreaterThanOrEqualTo(Float value) {
            addCriterion("message_price_unit >=", value, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitLessThan(Float value) {
            addCriterion("message_price_unit <", value, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitLessThanOrEqualTo(Float value) {
            addCriterion("message_price_unit <=", value, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitIn(List<Float> values) {
            addCriterion("message_price_unit in", values, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitNotIn(List<Float> values) {
            addCriterion("message_price_unit not in", values, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitBetween(Float value1, Float value2) {
            addCriterion("message_price_unit between", value1, value2, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andMessagePriceUnitNotBetween(Float value1, Float value2) {
            addCriterion("message_price_unit not between", value1, value2, "messagePriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountIsNull() {
            addCriterion("answer_token_count is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountIsNotNull() {
            addCriterion("answer_token_count is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountEqualTo(Integer value) {
            addCriterion("answer_token_count =", value, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountNotEqualTo(Integer value) {
            addCriterion("answer_token_count <>", value, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountGreaterThan(Integer value) {
            addCriterion("answer_token_count >", value, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_token_count >=", value, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountLessThan(Integer value) {
            addCriterion("answer_token_count <", value, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountLessThanOrEqualTo(Integer value) {
            addCriterion("answer_token_count <=", value, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountIn(List<Integer> values) {
            addCriterion("answer_token_count in", values, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountNotIn(List<Integer> values) {
            addCriterion("answer_token_count not in", values, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountBetween(Integer value1, Integer value2) {
            addCriterion("answer_token_count between", value1, value2, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerTokenCountNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_token_count not between", value1, value2, "answerTokenCount");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceIsNull() {
            addCriterion("answer_unit_price is null");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceIsNotNull() {
            addCriterion("answer_unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceEqualTo(Float value) {
            addCriterion("answer_unit_price =", value, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceNotEqualTo(Float value) {
            addCriterion("answer_unit_price <>", value, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceGreaterThan(Float value) {
            addCriterion("answer_unit_price >", value, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("answer_unit_price >=", value, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceLessThan(Float value) {
            addCriterion("answer_unit_price <", value, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceLessThanOrEqualTo(Float value) {
            addCriterion("answer_unit_price <=", value, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceIn(List<Float> values) {
            addCriterion("answer_unit_price in", values, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceNotIn(List<Float> values) {
            addCriterion("answer_unit_price not in", values, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceBetween(Float value1, Float value2) {
            addCriterion("answer_unit_price between", value1, value2, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerUnitPriceNotBetween(Float value1, Float value2) {
            addCriterion("answer_unit_price not between", value1, value2, "answerUnitPrice");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitIsNull() {
            addCriterion("answer_price_unit is null");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitIsNotNull() {
            addCriterion("answer_price_unit is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitEqualTo(Float value) {
            addCriterion("answer_price_unit =", value, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitNotEqualTo(Float value) {
            addCriterion("answer_price_unit <>", value, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitGreaterThan(Float value) {
            addCriterion("answer_price_unit >", value, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitGreaterThanOrEqualTo(Float value) {
            addCriterion("answer_price_unit >=", value, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitLessThan(Float value) {
            addCriterion("answer_price_unit <", value, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitLessThanOrEqualTo(Float value) {
            addCriterion("answer_price_unit <=", value, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitIn(List<Float> values) {
            addCriterion("answer_price_unit in", values, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitNotIn(List<Float> values) {
            addCriterion("answer_price_unit not in", values, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitBetween(Float value1, Float value2) {
            addCriterion("answer_price_unit between", value1, value2, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andAnswerPriceUnitNotBetween(Float value1, Float value2) {
            addCriterion("answer_price_unit not between", value1, value2, "answerPriceUnit");
            return (Criteria) this;
        }

        public Criteria andLatencyIsNull() {
            addCriterion("latency is null");
            return (Criteria) this;
        }

        public Criteria andLatencyIsNotNull() {
            addCriterion("latency is not null");
            return (Criteria) this;
        }

        public Criteria andLatencyEqualTo(Float value) {
            addCriterion("latency =", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotEqualTo(Float value) {
            addCriterion("latency <>", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyGreaterThan(Float value) {
            addCriterion("latency >", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyGreaterThanOrEqualTo(Float value) {
            addCriterion("latency >=", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyLessThan(Float value) {
            addCriterion("latency <", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyLessThanOrEqualTo(Float value) {
            addCriterion("latency <=", value, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyIn(List<Float> values) {
            addCriterion("latency in", values, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotIn(List<Float> values) {
            addCriterion("latency not in", values, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyBetween(Float value1, Float value2) {
            addCriterion("latency between", value1, value2, "latency");
            return (Criteria) this;
        }

        public Criteria andLatencyNotBetween(Float value1, Float value2) {
            addCriterion("latency not between", value1, value2, "latency");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountIsNull() {
            addCriterion("total_token_count is null");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountIsNotNull() {
            addCriterion("total_token_count is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountEqualTo(Integer value) {
            addCriterion("total_token_count =", value, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountNotEqualTo(Integer value) {
            addCriterion("total_token_count <>", value, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountGreaterThan(Integer value) {
            addCriterion("total_token_count >", value, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_token_count >=", value, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountLessThan(Integer value) {
            addCriterion("total_token_count <", value, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountLessThanOrEqualTo(Integer value) {
            addCriterion("total_token_count <=", value, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountIn(List<Integer> values) {
            addCriterion("total_token_count in", values, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountNotIn(List<Integer> values) {
            addCriterion("total_token_count not in", values, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountBetween(Integer value1, Integer value2) {
            addCriterion("total_token_count between", value1, value2, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalTokenCountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_token_count not between", value1, value2, "totalTokenCount");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Float value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Float value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Float value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Float value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Float value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Float> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Float> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Float value1, Float value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Float value1, Float value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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
        private LlmOpsMessageDOExample example;

        /**
         *
         * @mbg.generated
         */
        protected Criteria(LlmOpsMessageDOExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated
         */
        public LlmOpsMessageDOExample example() {
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
        void example(com.emcikem.llm.dao.example.LlmOpsMessageDOExample example);
    }
}