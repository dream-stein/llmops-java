package com.emcikem.llm.common.vo.apps;

import com.emcikem.llm.common.vo.apps.config.DatasetConfigVO;
import com.emcikem.llm.common.vo.apps.config.EnableConfigVO;
import com.emcikem.llm.common.vo.apps.config.RetrievalConfigVO;
import com.emcikem.llm.common.vo.apps.config.ReviewConfigVO;
import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DraftAppConfigVO {

    private String id;

//    private ModelConfigVO

    private Integer dialog_round;

    private String preset_prompt;

    private String opening_statement;

    private List<String> opening_questions;

    private RetrievalConfigVO retrieval_config;

    private ReviewConfigVO review_config;

    private EnableConfigVO long_term_memory;

    private EnableConfigVO suggested_after_answer;

    private List<DatasetConfigVO> datasets;

    private Long updated_at;

    private Long created_at;
}
// Object.assign(draftAppConfigForm, {
//   model_config: {
//     provider: '月之暗面',
//     model: 'Moonshot（128K）',
//     icon: 'https://nimg.ws.126.net/?url=http%3A%2F%2Fdingyue.ws.126.net%2F2024%2F0316%2Fb8184b8ej00saf80g002ad000ew00ejp.jpg&thumbnail=660x2147483647&quality=80&type=jpg',
//     parameters: [],
//   },
//   datasets: [
//     {
//       id: '46db30d1-3199-4e79-a0cd-abf12fa6858f',
//       name: 'book1',
//       icon: 'https://pic.616pic.com/ys_bnew_img/00/21/26/W0Y78oDGoQ.jpg',
//       description: 'i am book',
//     },
//   ],
//   tools: [
//     {
//       type: 'builtin_tool',
//       provider: {
//         id: '121',
//         name: 'google',
//         label: 'google',
//         icon: 'https://q2.itc.cn/q_70/images03/20240329/84cca9641e9444e5b3fe9256f095da6b.png',
//         description: '我是提供商',
//       },
//       tool: {
//         id: '22121',
//         name: 'google搜索',
//         label: 'search',
//         description: '搜索',
//         params: {},
//       },
//     },
//   ],
// })