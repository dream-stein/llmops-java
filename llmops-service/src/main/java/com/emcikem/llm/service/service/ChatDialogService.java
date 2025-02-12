package com.emcikem.llm.service.service;

import com.emcikem.llm.common.vo.ChatDialogVO;
import com.emcikem.llm.dao.entity.LlmOpsChatDialogDO;
import com.emcikem.llm.dao.example.LlmOpsChatDialogDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsChatDialogDOMapper;
import com.emcikem.llm.service.convert.ChatDialogConvert;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class ChatDialogService {

    @Resource
    private LlmOpsChatDialogDOMapper llmOpsChatDialogDOMapper;

    /**
     * 查询最近的100条记录
     * @return
     */
    public List<ChatDialogVO> queryDialogList(Long tenantId) {
        LlmOpsChatDialogDOExample example = new LlmOpsChatDialogDOExample();
        example.createCriteria().andTenantIdEqualTo(tenantId);
        example.setOffset(0);
        example.setRows(100);
        example.orderBy("id desc");
        List<LlmOpsChatDialogDO> llmOpsChatDialogDOS = llmOpsChatDialogDOMapper.selectByExample(example);

        return ChatDialogConvert.convert2ChatDialogVOList(llmOpsChatDialogDOS);
    }
}
