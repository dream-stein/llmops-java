package com.emcikem.llm.dao.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LlmOpsDocumentDOExample {
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
    public LlmOpsDocumentDOExample() {
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
    public LlmOpsDocumentDOExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsDocumentDOExample orderBy(String ... orderByClauses) {
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
    public LlmOpsDocumentDOExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsDocumentDOExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsDocumentDOExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public static Criteria newAndCreateCriteria() {
        LlmOpsDocumentDOExample example = new LlmOpsDocumentDOExample();
        return example.createCriteria();
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsDocumentDOExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    /**
     *
     * @mbg.generated
     */
    public LlmOpsDocumentDOExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
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
    public LlmOpsDocumentDOExample distinct(boolean distinct) {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdIsNull() {
            addCriterion("dataset_id is null");
            return (Criteria) this;
        }

        public Criteria andDatasetIdIsNotNull() {
            addCriterion("dataset_id is not null");
            return (Criteria) this;
        }

        public Criteria andDatasetIdEqualTo(String value) {
            addCriterion("dataset_id =", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdNotEqualTo(String value) {
            addCriterion("dataset_id <>", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdGreaterThan(String value) {
            addCriterion("dataset_id >", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdGreaterThanOrEqualTo(String value) {
            addCriterion("dataset_id >=", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdLessThan(String value) {
            addCriterion("dataset_id <", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdLessThanOrEqualTo(String value) {
            addCriterion("dataset_id <=", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdLike(String value) {
            addCriterion("dataset_id like", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdNotLike(String value) {
            addCriterion("dataset_id not like", value, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdIn(List<String> values) {
            addCriterion("dataset_id in", values, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdNotIn(List<String> values) {
            addCriterion("dataset_id not in", values, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdBetween(String value1, String value2) {
            addCriterion("dataset_id between", value1, value2, "datasetId");
            return (Criteria) this;
        }

        public Criteria andDatasetIdNotBetween(String value1, String value2) {
            addCriterion("dataset_id not between", value1, value2, "datasetId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdIsNull() {
            addCriterion("upload_file_id is null");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdIsNotNull() {
            addCriterion("upload_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdEqualTo(String value) {
            addCriterion("upload_file_id =", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdNotEqualTo(String value) {
            addCriterion("upload_file_id <>", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdGreaterThan(String value) {
            addCriterion("upload_file_id >", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("upload_file_id >=", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdLessThan(String value) {
            addCriterion("upload_file_id <", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdLessThanOrEqualTo(String value) {
            addCriterion("upload_file_id <=", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdLike(String value) {
            addCriterion("upload_file_id like", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdNotLike(String value) {
            addCriterion("upload_file_id not like", value, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdIn(List<String> values) {
            addCriterion("upload_file_id in", values, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdNotIn(List<String> values) {
            addCriterion("upload_file_id not in", values, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdBetween(String value1, String value2) {
            addCriterion("upload_file_id between", value1, value2, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andUploadFileIdNotBetween(String value1, String value2) {
            addCriterion("upload_file_id not between", value1, value2, "uploadFileId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdIsNull() {
            addCriterion("process_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdIsNotNull() {
            addCriterion("process_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdEqualTo(String value) {
            addCriterion("process_rule_id =", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdNotEqualTo(String value) {
            addCriterion("process_rule_id <>", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdGreaterThan(String value) {
            addCriterion("process_rule_id >", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_rule_id >=", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdLessThan(String value) {
            addCriterion("process_rule_id <", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdLessThanOrEqualTo(String value) {
            addCriterion("process_rule_id <=", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdLike(String value) {
            addCriterion("process_rule_id like", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdNotLike(String value) {
            addCriterion("process_rule_id not like", value, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdIn(List<String> values) {
            addCriterion("process_rule_id in", values, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdNotIn(List<String> values) {
            addCriterion("process_rule_id not in", values, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdBetween(String value1, String value2) {
            addCriterion("process_rule_id between", value1, value2, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andProcessRuleIdNotBetween(String value1, String value2) {
            addCriterion("process_rule_id not between", value1, value2, "processRuleId");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(Integer value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(Integer value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(Integer value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(Integer value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(Integer value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<Integer> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<Integer> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(Integer value1, Integer value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andCharacterCountIsNull() {
            addCriterion("character_count is null");
            return (Criteria) this;
        }

        public Criteria andCharacterCountIsNotNull() {
            addCriterion("character_count is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterCountEqualTo(Integer value) {
            addCriterion("character_count =", value, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountNotEqualTo(Integer value) {
            addCriterion("character_count <>", value, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountGreaterThan(Integer value) {
            addCriterion("character_count >", value, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("character_count >=", value, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountLessThan(Integer value) {
            addCriterion("character_count <", value, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountLessThanOrEqualTo(Integer value) {
            addCriterion("character_count <=", value, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountIn(List<Integer> values) {
            addCriterion("character_count in", values, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountNotIn(List<Integer> values) {
            addCriterion("character_count not in", values, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountBetween(Integer value1, Integer value2) {
            addCriterion("character_count between", value1, value2, "characterCount");
            return (Criteria) this;
        }

        public Criteria andCharacterCountNotBetween(Integer value1, Integer value2) {
            addCriterion("character_count not between", value1, value2, "characterCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountIsNull() {
            addCriterion("token_count is null");
            return (Criteria) this;
        }

        public Criteria andTokenCountIsNotNull() {
            addCriterion("token_count is not null");
            return (Criteria) this;
        }

        public Criteria andTokenCountEqualTo(Integer value) {
            addCriterion("token_count =", value, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountNotEqualTo(Integer value) {
            addCriterion("token_count <>", value, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountGreaterThan(Integer value) {
            addCriterion("token_count >", value, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("token_count >=", value, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountLessThan(Integer value) {
            addCriterion("token_count <", value, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountLessThanOrEqualTo(Integer value) {
            addCriterion("token_count <=", value, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountIn(List<Integer> values) {
            addCriterion("token_count in", values, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountNotIn(List<Integer> values) {
            addCriterion("token_count not in", values, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountBetween(Integer value1, Integer value2) {
            addCriterion("token_count between", value1, value2, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andTokenCountNotBetween(Integer value1, Integer value2) {
            addCriterion("token_count not between", value1, value2, "tokenCount");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtIsNull() {
            addCriterion("processing_started_at is null");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtIsNotNull() {
            addCriterion("processing_started_at is not null");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtEqualTo(Date value) {
            addCriterion("processing_started_at =", value, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtNotEqualTo(Date value) {
            addCriterion("processing_started_at <>", value, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtGreaterThan(Date value) {
            addCriterion("processing_started_at >", value, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("processing_started_at >=", value, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtLessThan(Date value) {
            addCriterion("processing_started_at <", value, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtLessThanOrEqualTo(Date value) {
            addCriterion("processing_started_at <=", value, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtIn(List<Date> values) {
            addCriterion("processing_started_at in", values, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtNotIn(List<Date> values) {
            addCriterion("processing_started_at not in", values, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtBetween(Date value1, Date value2) {
            addCriterion("processing_started_at between", value1, value2, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andProcessingStartedAtNotBetween(Date value1, Date value2) {
            addCriterion("processing_started_at not between", value1, value2, "processingStartedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtIsNull() {
            addCriterion("parsing_completed_at is null");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtIsNotNull() {
            addCriterion("parsing_completed_at is not null");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtEqualTo(Date value) {
            addCriterion("parsing_completed_at =", value, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtNotEqualTo(Date value) {
            addCriterion("parsing_completed_at <>", value, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtGreaterThan(Date value) {
            addCriterion("parsing_completed_at >", value, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("parsing_completed_at >=", value, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtLessThan(Date value) {
            addCriterion("parsing_completed_at <", value, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtLessThanOrEqualTo(Date value) {
            addCriterion("parsing_completed_at <=", value, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtIn(List<Date> values) {
            addCriterion("parsing_completed_at in", values, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtNotIn(List<Date> values) {
            addCriterion("parsing_completed_at not in", values, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtBetween(Date value1, Date value2) {
            addCriterion("parsing_completed_at between", value1, value2, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andParsingCompletedAtNotBetween(Date value1, Date value2) {
            addCriterion("parsing_completed_at not between", value1, value2, "parsingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtIsNull() {
            addCriterion("splitting_completed_at is null");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtIsNotNull() {
            addCriterion("splitting_completed_at is not null");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtEqualTo(Date value) {
            addCriterion("splitting_completed_at =", value, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtNotEqualTo(Date value) {
            addCriterion("splitting_completed_at <>", value, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtGreaterThan(Date value) {
            addCriterion("splitting_completed_at >", value, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("splitting_completed_at >=", value, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtLessThan(Date value) {
            addCriterion("splitting_completed_at <", value, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtLessThanOrEqualTo(Date value) {
            addCriterion("splitting_completed_at <=", value, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtIn(List<Date> values) {
            addCriterion("splitting_completed_at in", values, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtNotIn(List<Date> values) {
            addCriterion("splitting_completed_at not in", values, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtBetween(Date value1, Date value2) {
            addCriterion("splitting_completed_at between", value1, value2, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andSplittingCompletedAtNotBetween(Date value1, Date value2) {
            addCriterion("splitting_completed_at not between", value1, value2, "splittingCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtIsNull() {
            addCriterion("index_completed_at is null");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtIsNotNull() {
            addCriterion("index_completed_at is not null");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtEqualTo(Date value) {
            addCriterion("index_completed_at =", value, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtNotEqualTo(Date value) {
            addCriterion("index_completed_at <>", value, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtGreaterThan(Date value) {
            addCriterion("index_completed_at >", value, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("index_completed_at >=", value, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtLessThan(Date value) {
            addCriterion("index_completed_at <", value, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtLessThanOrEqualTo(Date value) {
            addCriterion("index_completed_at <=", value, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtIn(List<Date> values) {
            addCriterion("index_completed_at in", values, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtNotIn(List<Date> values) {
            addCriterion("index_completed_at not in", values, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtBetween(Date value1, Date value2) {
            addCriterion("index_completed_at between", value1, value2, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andIndexCompletedAtNotBetween(Date value1, Date value2) {
            addCriterion("index_completed_at not between", value1, value2, "indexCompletedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtIsNull() {
            addCriterion("completed_at is null");
            return (Criteria) this;
        }

        public Criteria andCompletedAtIsNotNull() {
            addCriterion("completed_at is not null");
            return (Criteria) this;
        }

        public Criteria andCompletedAtEqualTo(Date value) {
            addCriterion("completed_at =", value, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtNotEqualTo(Date value) {
            addCriterion("completed_at <>", value, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtGreaterThan(Date value) {
            addCriterion("completed_at >", value, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("completed_at >=", value, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtLessThan(Date value) {
            addCriterion("completed_at <", value, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtLessThanOrEqualTo(Date value) {
            addCriterion("completed_at <=", value, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtIn(List<Date> values) {
            addCriterion("completed_at in", values, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtNotIn(List<Date> values) {
            addCriterion("completed_at not in", values, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtBetween(Date value1, Date value2) {
            addCriterion("completed_at between", value1, value2, "completedAt");
            return (Criteria) this;
        }

        public Criteria andCompletedAtNotBetween(Date value1, Date value2) {
            addCriterion("completed_at not between", value1, value2, "completedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtIsNull() {
            addCriterion("stopped_at is null");
            return (Criteria) this;
        }

        public Criteria andStoppedAtIsNotNull() {
            addCriterion("stopped_at is not null");
            return (Criteria) this;
        }

        public Criteria andStoppedAtEqualTo(Date value) {
            addCriterion("stopped_at =", value, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtNotEqualTo(Date value) {
            addCriterion("stopped_at <>", value, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtGreaterThan(Date value) {
            addCriterion("stopped_at >", value, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("stopped_at >=", value, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtLessThan(Date value) {
            addCriterion("stopped_at <", value, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtLessThanOrEqualTo(Date value) {
            addCriterion("stopped_at <=", value, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtIn(List<Date> values) {
            addCriterion("stopped_at in", values, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtNotIn(List<Date> values) {
            addCriterion("stopped_at not in", values, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtBetween(Date value1, Date value2) {
            addCriterion("stopped_at between", value1, value2, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andStoppedAtNotBetween(Date value1, Date value2) {
            addCriterion("stopped_at not between", value1, value2, "stoppedAt");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andDisabledAtIsNull() {
            addCriterion("disabled_at is null");
            return (Criteria) this;
        }

        public Criteria andDisabledAtIsNotNull() {
            addCriterion("disabled_at is not null");
            return (Criteria) this;
        }

        public Criteria andDisabledAtEqualTo(Date value) {
            addCriterion("disabled_at =", value, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtNotEqualTo(Date value) {
            addCriterion("disabled_at <>", value, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtGreaterThan(Date value) {
            addCriterion("disabled_at >", value, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtGreaterThanOrEqualTo(Date value) {
            addCriterion("disabled_at >=", value, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtLessThan(Date value) {
            addCriterion("disabled_at <", value, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtLessThanOrEqualTo(Date value) {
            addCriterion("disabled_at <=", value, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtIn(List<Date> values) {
            addCriterion("disabled_at in", values, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtNotIn(List<Date> values) {
            addCriterion("disabled_at not in", values, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtBetween(Date value1, Date value2) {
            addCriterion("disabled_at between", value1, value2, "disabledAt");
            return (Criteria) this;
        }

        public Criteria andDisabledAtNotBetween(Date value1, Date value2) {
            addCriterion("disabled_at not between", value1, value2, "disabledAt");
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
        private LlmOpsDocumentDOExample example;

        /**
         *
         * @mbg.generated
         */
        protected Criteria(LlmOpsDocumentDOExample example) {
            super();
            this.example = example;
        }

        /**
         *
         * @mbg.generated
         */
        public LlmOpsDocumentDOExample example() {
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
        void example(com.emcikem.llm.dao.example.LlmOpsDocumentDOExample example);
    }
}