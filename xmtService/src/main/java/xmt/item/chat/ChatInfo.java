package xmt.item.chat;

public class ChatInfo {
    private String userId;
    private String name;
    private String img;

    private int type;//1群聊 2单聊
    private String fromUserSession;
    private String toUserSession;
    private String fromUserName;
    private String toUserName;

    private String fromUserId;
    private String toUserId;
    private String msg;

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserSession() {
        return fromUserSession;
    }

    public void setFromUserSession(String fromUserSession) {
        this.fromUserSession = fromUserSession;
    }

    public String getToUserSession() {
        return toUserSession;
    }

    public void setToUserSession(String toUserSession) {
        this.toUserSession = toUserSession;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
