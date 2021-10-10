package xmt.item.chat;
import java.util.List;
import org.springframework.stereotype.Service;
import xmt.item.util.AppResponse;

import javax.annotation.Resource;

@Service
public class ChatService {

    @Resource
    private ChatDao chatDao;

    public AppResponse addChat(ChatInfo chatInfo){
        int add = chatDao.addChat(chatInfo);
        return AppResponse.success("成功",add);
    }

    /**
     * @查询聊天列表
     * @param chatInfo
     * @return
     */
    public AppResponse userChatList(ChatInfo chatInfo){
        List<ChatInfo>chatInfoList = chatDao.userChatList(chatInfo);
        return AppResponse.success("成功",chatInfoList);
    }

    /**
     * @查询聊天记录
     * @param chatInfo
     * @return
     */
    public AppResponse selectChatRecord(ChatInfo chatInfo){
        List<ChatInfo>chatInfoList = chatDao.selectChatRecord(chatInfo);
        return AppResponse.success("成功",chatInfoList);
    }
}
