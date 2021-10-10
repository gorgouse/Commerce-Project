package xmt.item.chat;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatDao {
    /**
     * 新增聊天
     * @param chatInfo
     * @return
     */
    int addChat(ChatInfo chatInfo);
    /**
     *查询聊天列表
     * @param chatInfo
     * @return
     */
    List<ChatInfo>userChatList(ChatInfo chatInfo);

    /**
     *查询聊天记录
     * @param chatInfo
     * @return
     */
    List<ChatInfo>selectChatRecord(ChatInfo chatInfo);
}
