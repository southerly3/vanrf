package com.vanrf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * User 实体类
 */
public class User implements Serializable {
    private Long userId; //Id
    private String username; //账号
    private String password; //密码
    private String imgs; //头像
    private String status; //身份



    /**
     * 空构造方法
     */
    public User() {
    }
    /**
     * Get Set方法
     *
     * @return
     */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", imgs='" + imgs + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
