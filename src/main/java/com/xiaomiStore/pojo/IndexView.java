package com.xiaomiStore.pojo;

import java.util.ArrayList;
import java.util.List;

public class IndexView {
    private List<OriginType> originTypeList;

    public IndexView() {
        this.originTypeList = new ArrayList<>();
    }

    public IndexView(List<OriginType> originTypeList) {

        this.originTypeList = originTypeList;
    }

    @Override
    public String toString() {
        return "IndexView{\n" +
                "originTypeList=" + originTypeList +
                "\n}";
    }

    public List<OriginType> getOriginTypeList() {
        return originTypeList;
    }

    public void setOriginTypeList(List<OriginType> originTypeList) {
        this.originTypeList = originTypeList;
    }
}
