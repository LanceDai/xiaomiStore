package com.xiaomiStore.pojo;

public class Type {
    private String typeId;
    private String name;
    private String parentId;

    @Override
    public String toString() {
        return "Type{" +
                "typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Type(String typeId, String name, String parentId) {

        this.typeId = typeId;
        this.name = name;
        this.parentId = parentId;
    }

    public Type() {

    }
}
