package com.emcikem.llm.common.vo.dataset;

import com.emcikem.llm.common.enums.ProcessTypeEnum;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/15
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class CreateDocumentsParam {

    private List<String> upload_file_ids;

    private String process_type;

    private CreateDocumentRuleVO rule;

    public void buildDefaultRule() {
        this.process_type = ProcessTypeEnum.CUSTOM.getDesc();
        CreateDocumentRuleVO rule = new CreateDocumentRuleVO();
        CreateDocumentSegmentVO segment = new CreateDocumentSegmentVO();
        segment.setSeparators(Lists.newArrayList(
                "\n\n",
                "\n",
                "。|!|?",
                "\\.|\\\\!|\\\\?|\\\\s", // 英文标点符号后面通常需要加空格
                ";|;\\s",
                ",|,\\s",
                " ",
                ""
        ));
        segment.setChunk_size(500L);
        segment.setChunk_overlap(50L);
        rule.setSegment(segment);

        CreateDocumentPreProcessRuleVO spacePreRule = new CreateDocumentPreProcessRuleVO();
        spacePreRule.setId("remove_extra_space");
        spacePreRule.setEnabled(true);
        CreateDocumentPreProcessRuleVO emailPreRule = new CreateDocumentPreProcessRuleVO();
        emailPreRule.setId("remove_url_and_email");
        emailPreRule.setEnabled(true);
        rule.setPre_process_rules(Lists.newArrayList(spacePreRule));
        this.rule = rule;
    }
}
