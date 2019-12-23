package com.vanrf.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Message实体类
 */
public class Message implements Serializable{
    private int messageId; //Id
    private String nickName; //昵称
    private String imgs; //头像路径
    private String address; //地址
    private String content; //内容
    private String Time; //时间



    /**
     * 空构造方法
     */
    public Message() {
    }

    /**
     * Get Set方法
     */
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    /**
     * toString方法
     */
    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", nickName='" + nickName + '\'' +
                ", imgs='" + imgs + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", Time=" + Time +
                '}';
    }
}
