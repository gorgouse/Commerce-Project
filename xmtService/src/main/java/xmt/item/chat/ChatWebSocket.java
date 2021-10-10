package xmt.item.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import xmt.item.config.websocket.SocketMsg;
import xmt.item.util.AppResponse;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
@Component
@ServerEndpoint(value = "/personalChat/{nickname}/{id}")
public class ChatWebSocket {
    private String userId;
    private String nickname;
    private Session session;
    private static CopyOnWriteArraySet<ChatWebSocket> webSockets = new CopyOnWriteArraySet<>();//<sessionId,(nickname,session)>
    private static Map<String,Session> map = new HashMap<>();// -><userId,Session>

    @OnOpen
    public void onOpen(Session session,@PathParam("id")String id,@PathParam("nickname")String nickname) throws IOException {//自己id
        Map<String,Object> message = new HashMap<>();
        this.userId = id;
        this.nickname = nickname;
        this.session = session;
        map.put(id,session);//<userId,Session>
        webSockets.add(this);
        System.out.println("WebSocket容器创建连接成功，当前用户编号："+id+",当前用户："+nickname);
        message.put("userId",id);
        message.put("type",0);//消息发送结果：0成功：1接受消息
        message.put("sessionId",session.getId());
        message.put("people",webSockets.size());
        this.session.getBasicRemote().sendText(new Gson().toJson(message));
    }

    @OnMessage
    public void OnMessage(String socketInfo, Session session,@PathParam("id")String id, @PathParam("nickname") String nickname) throws IOException{//只能允许有一个非路径的参数
        ObjectMapper objectMapper = new ObjectMapper();
        ChatInfo chatInfo;
        chatInfo = objectMapper.readValue(socketInfo,ChatInfo.class);//Json转化为实体类
        //找到发送者和接收者
        chatInfo.setFromUserSession(session.getId());//发送者
        Session fromSession = map.get(id); //map通过sessionId获取session
        Session toSession = map.get(chatInfo.getToUserId());
        System.out.println("当前用户编号为："+id+" 给用户编号为 "+chatInfo.getToUserId()+" 发送消息为："+chatInfo.getMsg());

        //发送给发送者
        Map<String,Object> m = new HashMap<>();
        m.put("type",1);
        m.put("name",nickname);
        m.put("msg",chatInfo.getMsg());
        m.put("fromUserId",id);
        m.put("toUserId",chatInfo.getToUserId());
        fromSession.getAsyncRemote().sendText(new Gson().toJson(m));
        if(toSession != null && toSession.isOpen() == true){
            toSession.getAsyncRemote().sendText(new Gson().toJson(m));
        }
    }

    /**
     * 连接关闭调用的方法    
     */
    @OnClose
    public void onClose() {
        webSockets.remove(this); //从set中删除
        System.out.println("有一连接关闭！当前在线人数为" + webSockets.size());
    }

    /**
     * 发生错误时调用   
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
}
