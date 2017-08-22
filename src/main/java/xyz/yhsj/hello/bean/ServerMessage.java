package xyz.yhsj.hello.bean;

/**
 * 服务器返回给浏览器的消息由这个类来承载：
 */
public class ServerMessage {
    private String responseMessage;

    public ServerMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}