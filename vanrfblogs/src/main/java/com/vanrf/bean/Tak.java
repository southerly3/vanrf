package com.vanrf.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Tak实体类
 */
public class Tak implements  Serializable{
    private int takId;
    private String takName;

    /**
     * 空构造方法
     */
    public Tak() {
    }

    /**
     * Get Set方法
     */
    public int getTakId() {
        return takId;
    }

    public void setTakId(int takId) {
        this.takId = takId;
    }

    public String getTakName() {
        return takName;
    }

    public void setTakName(String takName) {
        this.takName = takName;
    }

    /**
     * toString方法
     */
    @Override
    public String toString() {
        return "Tak{" +
                "takId=" + takId +
                ", takName='" + takName + '\'' +
                '}';
    }
}
