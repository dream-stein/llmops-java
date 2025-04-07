package com.emcikem.llm.service.service.builtintool;

import com.emcikem.llm.common.enums.BuiltinToolCategoryEnum;
import com.emcikem.llm.common.vo.builtintool.GetCategoryVO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsBuiltinToolService {

    public List<GetCategoryVO> getCategories() {
        return Arrays.stream(BuiltinToolCategoryEnum.values()).map(x -> {
            GetCategoryVO categoryVO = new GetCategoryVO();
            categoryVO.setName(x.getCategoryName());
            categoryVO.setCategory(String.valueOf(x.getCategoryId()));
//            categoryVO.setIcon();
            return categoryVO;
        }).collect(Collectors.toList());
    }
}
