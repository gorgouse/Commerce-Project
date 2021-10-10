package xmt.item.chat;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xmt.item.util.AppResponse;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Resource
    private ChatService chatService;

    /**
     * 新增聊天
     * @param chatInfo
     * @return
     */
    @GetMapping("/addChat")
    public AppResponse addChat(ChatInfo chatInfo){
        return chatService.addChat(chatInfo);
    }

    /**
     * 查询店铺消息列表
     * @param chatInfo
     * @return
     */
    @GetMapping("/userChatList")
    public AppResponse userChatList(ChatInfo chatInfo){
        return chatService.userChatList(chatInfo);
    }

    /**
     * 查询客户消息列表
     * @param chatInfo
     * @return
     */
    @GetMapping("/selectChatRecord")
    public AppResponse selectChatRecord(ChatInfo chatInfo){
        return chatService.selectChatRecord(chatInfo);
    }
}
