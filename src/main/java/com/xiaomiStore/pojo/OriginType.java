package com.xiaomiStore.pojo;

import java.util.List;

public class OriginType {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private List<Type> typeList;
    private List<Product> productList;

    @Override
    public String toString() {
        return "OriginType{" +
                "\ntype=" + type +
                "\n, typeList=" + typeList +
                "\n, productList=" + productList +
                '}';
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public OriginType() {
    }

    public OriginType(Type type, List<Type> typeList, List<Product> productList) {
        this.type = type;
        this.typeList = typeList;
        this.productList = productList;
    }
}
