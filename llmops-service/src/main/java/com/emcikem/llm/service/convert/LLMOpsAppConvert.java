package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.apps.AppVO;
import com.emcikem.llm.dao.entity.LlmOpsAppDO;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
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
        appVO.setDescription(appDO.getDescription());
        appVO.setStatus(appDO.getStatus());
        appVO.setIcon(appDO.getIcon());
//        appVO.setPreset_prompt(appDO.get);
        appVO.setCreated_at(appDO.getCreatedAt().getTime());
        appVO.setUpdated_at(appDO.getUpdatedAt().getTime());
//        appVO.setModel_config(appDO.get);
        return appVO;
    }
}
