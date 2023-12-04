package com.murasame_ai.murasame_singapi.controller;

import cn.gjsm.api.openai.OpenAiClient;
import cn.gjsm.api.openai.OpenAiClientFactory;
import cn.gjsm.api.pojo.chat.ChatCompletionRequest;
import cn.gjsm.api.pojo.chat.ChatCompletionResponse;
import cn.gjsm.api.pojo.chat.ChatMessage;
import com.google.gson.Gson;
import com.murasame_ai.murasame_singapi.config.BaiduConfig.TransApi;
import com.murasame_ai.murasame_singapi.config.R;
import com.murasame_ai.murasame_singapi.config.ResPara;
import com.murasame_ai.murasame_singapi.pojo.Reply;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/murasamesing/")
public class TrasitionController {
    private static final String APP_ID = "20231203001899697";
    private static final String SECURITY_KEY = "E4XwCoRKqZta5NqQYuuC";


    /**
     * 基本思想是这样的：
     * 前端传到后端的数据：
     * [
     *  {
     *      "role":"user",
     *      "content":"问题"        //日文
     *  },.......
     * ]
     *
     * 后端返回给前端的数据（其中必须包含返回给前端的数据）:
     * {
     *     rid:'',          //日文问题
     *     content:'',      //日文回复
     *     keyword:'',      //中文回复
     *     emotion:''       //中文问题
     * }
     */


    // 总接口，直接调用这一个接口就行了
    @PostMapping("Change")
    public R Change(@RequestBody List<ChatMessage> messageList) throws IOException {
        try {
            Reply reply = new Reply();
            String jp = trans(messageList.get(messageList.size() - 1).getContent(), "jp");
            reply.setEmotion(messageList.get(messageList.size()-1).getContent());   //设置中文问题
            reply.setRid(jp);                                                       //设置日文问题

            messageList.get(messageList.size()-1).setContent(jp);                   //将日文问题装入数组中，便于chat接口处理

            Reply newReply = (Reply) chat(messageList).getData();
            reply.setContent(newReply.getContent());                                //设置日文回复
            reply.setKeyword(trans(newReply.getContent(),"zh"));                 //设置中文回复
            return new R("200", reply);
        }catch (Exception e){
            return new R("500",e.getMessage());
        }
    }

    // 翻译
    @GetMapping("trans/{quary}/{to}")
    public String trans(@PathVariable String quary, @PathVariable String to) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String domain = "";
        //翻译接口
        ResPara resPara = new Gson()
                .fromJson(api.getTransResult(quary, "auto", to, domain), ResPara.class);
        ResPara.message message = resPara.getTrans_result().get(0);
        return message.getDst();
    }


//    chat链接
    /**
     * 聊天端点
     */
    public String openaiApiKey = "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";

    @PostMapping("chat")
    public R chat(@RequestBody List<ChatMessage> messageList) throws IOException {
        OpenAiClient client = OpenAiClientFactory.createClient(openaiApiKey);

        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .messages(messageList)
                .build();
        Response<ChatCompletionResponse> execute = client.callChatCompletion(request).execute();
        if (execute.isSuccessful()) {
            return new R("200", new Reply(execute.body().getChoices().get(0).getMessage().getContent()));
        } else {
            return new R("500");
        }
    }
}
