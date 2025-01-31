package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.ChatDialogVO;
import com.emcikem.llm.dao.entity.LlmOpsChatDialogDO;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChatDialogConvert {

  public static List<LlmOpsChatDialogDO> convert2ChatDialogDOList(List<ChatDialogVO> dialogVOList) {
    if (CollectionUtils.isEmpty(dialogVOList)) {
      return Lists.newArrayList();
    }
    return dialogVOList.stream().map(ChatDialogConvert::convert2ChatDialogDO).filter(Objects::nonNull).collect(Collectors.toList());
  }

  public static LlmOpsChatDialogDO convert2ChatDialogDO(ChatDialogVO dialogVO) {
    if (dialogVO == null) {
      return null;
    }
    LlmOpsChatDialogDO dialogDO = new LlmOpsChatDialogDO();
    dialogDO.setId(dialogVO.getId());
    dialogDO.setTenantId(dialogVO.getTenantId());
    dialogDO.setTitle(dialogVO.getName());

    return dialogDO;
  }

  public static List<ChatDialogVO> convert2ChatDialogVOList(List<LlmOpsChatDialogDO> dialogDOList) {
    if (CollectionUtils.isEmpty(dialogDOList)) {
      return Lists.newArrayList();
    }
    return dialogDOList.stream().map(ChatDialogConvert::convert2ChatDialogVO).filter(Objects::nonNull).collect(Collectors.toList());
  }

  public static ChatDialogVO convert2ChatDialogVO(LlmOpsChatDialogDO dialogDO) {
    if (dialogDO == null) {
      return null;
    }
    ChatDialogVO chatDialogVO = new ChatDialogVO();
    chatDialogVO.setId(dialogDO.getId());
    chatDialogVO.setName(dialogDO.getTitle());

    return chatDialogVO;
  }

}
