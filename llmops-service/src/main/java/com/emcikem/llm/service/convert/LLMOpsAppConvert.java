package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.apps.AppDetailVO;
import com.emcikem.llm.common.vo.apps.AppVO;
import com.emcikem.llm.common.vo.apps.ModelConfigVO;
import com.emcikem.llm.dao.entity.LlmOpsAppDO;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class LLMOpsAppConvert {

    public static List<AppVO> convert(List<LlmOpsAppDO> appList) {
        if (CollectionUtils.isEmpty(appList)) {
            return Lists.newArrayList();
        }
        return appList.stream().map(LLMOpsAppConvert::convert).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static AppVO convert(LlmOpsAppDO appDO) {
        if (appDO == null) {
            return null;
        }
        AppVO appVO = new AppVO();
        appVO.setId(appDO.getId());
        appVO.setName(appDO.getName());
        appVO.setDescription("122112");
        appVO.setStatus(appDO.getStatus());
        appVO.setIcon(appDO.getIcon());
        appVO.setPreset_prompt("2121");
        appVO.setCreated_at(appDO.getCreatedAt().getTime());
        appVO.setUpdated_at(appDO.getUpdatedAt().getTime());
        ModelConfigVO modelConfigVO = new ModelConfigVO();
        modelConfigVO.setModel("deepseek");
        modelConfigVO.setProvider("月之暗面");
        appVO.setModel_config(modelConfigVO);

        return appVO;
    }

    public static AppDetailVO convert2DetailVO(LlmOpsAppDO appDO) {
        if (appDO == null) {
            return null;
        }
        AppDetailVO detailVO = new AppDetailVO();
        detailVO.setId(appDO.getId());
        detailVO.setName(appDO.getName());
        detailVO.setDescription("122112");
        detailVO.setStatus(appDO.getStatus());
        detailVO.setIcon(appDO.getIcon());
        detailVO.setCreated_at(appDO.getCreatedAt().getTime());
        detailVO.setUpdated_at(appDO.getUpdatedAt().getTime());
        detailVO.setDebug_conversation_id("111");
        detailVO.setDraft_updated_at(2121121212L);
        return detailVO;
    }
}
