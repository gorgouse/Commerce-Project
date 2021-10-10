package xmt.item.config.websocket;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.springframework.stereotype.Component;
import xmt.item.config.websocket.SocketMsg;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
@ServerEndpoint(value = "/websocket/{nickname}")
@Component
public class WebSocketService {
    private String nickname;
    private Session session;
    private static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<>();//{session,nickname},{session,nickname}...
    private static Map<String,Session> map = new HashMap<>();//key:sessionId,value:session...

    @OnOpen
    public void onOpen(Session session, @PathParam("nickname")String nickname){
        Map<String,Object> message = new HashMap<>();
        this.session = session;
        this.nickname = nickname;
        webSocketSet.add(this);
        map.put(session.getId(),session);
        System.out.println("有新连接加入:" + nickname + ",当前在线人数为" + webSocketSet.size());
        message.put("type",0); //消息类型，0-连接成功，1-用户消息
        message.put("people",webSocketSet.size()); //在线人数
        message.put("name",nickname); //昵称
        message.put("aisle",session.getId()); //频道号
        this.session.getAsyncRemote().sendText(new Gson().toJson(message));
    }

    /**
     * 连接关闭调用的方法    
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this); //从set中删除
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("nickname") String nickname) {
        System.out.println("来自客户端的消息-->" + nickname + ": " + message);

        //从客户端传过来的数据是json数据，所以这里使用jackson进行转换为SocketMsg对象，
        // 然后通过socketMsg的type进行判断是单聊还是群聊，进行相应的处理:
        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsg socketMsg;

        try {
            socketMsg = objectMapper.readValue(message, SocketMsg.class);//将message(json对象)转变为SocketMsg的实体类
            if (socketMsg.getType() == 1) {
                //单聊.需要找到发送者和接受者.
                socketMsg.setFromUser(session.getId());//发送者sessionId
                Session fromSession = map.get(socketMsg.getFromUser());//获取当前容器中发送者session
                Session toSession = map.get(socketMsg.getToUserId());//获取当前容器中接受者session
                //发送给接受者.
                if (toSession != null) {
                    //发送给发送者.
                    Map<String,Object> m=new HashMap<String, Object>();
                    m.put("type",1);
                    m.put("name",nickname);
                    m.put("msg",socketMsg.getMsg());
                    fromSession.getAsyncRemote().sendText(new Gson().toJson(m));
                    toSession.getAsyncRemote().sendText(new Gson().toJson(m));
                } else {
                    //发送给发送者.
                    fromSession.getAsyncRemote().sendText("系统消息：对方不在线或者您输入的频道号不对");
                }
            }
            else {
                //群发消息
                broadcast(nickname + ": " + socketMsg.getMsg());
            }

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发生错误时调用   
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 群发自定义消息
     */
    public void broadcast(String message) {
        for (WebSocketService item : webSocketSet) {
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }

}
