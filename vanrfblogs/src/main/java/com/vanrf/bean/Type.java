package com.vanrf.bean;

import java.io.Serializable;

/**
 * Type 实体类
 */
public class Type implements Serializable{
    private int typeId;
    private String typeName;


    /**
     * 空构造方法
     */
    public Type() {
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     * Get Set方法
     */

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * toString方法
     */
    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
