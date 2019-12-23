package com.vanrf.bean;

import java.io.Serializable;

/**
 * Blog实体类
 */
public class Blog implements Serializable {
    private Long blogId; //Id
    private String title; //标题
    private String author; //作者
    private String contentMd; //MD格式内容
    private String contentHTML; //HTML格式内容
    private int views; //浏览次数
    private String createTime; //创建时间
    private String updateTime; //修改时间
    private int state; //状态       0 未启用 1启用
    private int publish; //文章发布 0未发布 1发布
    private String blogType; //类型 原创/转载
    private String imgs; //图片路径
    private String typeName; //类型名称
    private String intro; //文章简介
    /**
     * 空构造方法
     */
    public Blog() {
    }



    /**
     * Get Set 方法
     */
    public String getBlogType() {
        return blogType;
    }

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }


    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentMd() {
        return contentMd;
    }

    public void setContentMd(String contentMd) {
        this.contentMd = contentMd;
    }

    public String getContentHTML() {
        return contentHTML;
    }

    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /**
     * toString 方法
     */
    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", contentMd='" + contentMd + '\'' +
                ", contentHTML='" + contentHTML + '\'' +
                ", views=" + views +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", state=" + state +
                ", publish=" + publish +
                ", blogType='" + blogType + '\'' +
                ", imgs='" + imgs + '\'' +
                ", typeName='" + typeName + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}

