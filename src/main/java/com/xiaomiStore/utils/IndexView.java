package com.xiaomiStore.utils;

import com.xiaomiStore.pojo.OriginType;

import java.util.ArrayList;
import java.util.List;

public class IndexView {
    private List<OriginType> originTypeList;

    public List<OriginType> getOriginTypeList() {
        return originTypeList;
    }

    public void setOriginTypeList(List<OriginType> originTypeList) {
        this.originTypeList = originTypeList;
    }

    public IndexView() {
        this.originTypeList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "IndexView{\n" +
                "originTypeList=" + originTypeList +
                "\n}";
    }

}
