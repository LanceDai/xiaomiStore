package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Type;

import java.util.List;

public interface TypeService {

    int insert(Type record);

    List<Type> selectAll();

    Type selectByPrimaryKey(String typeId);

    List<Type> selectByParentId(String parentId);

    Type selectByName(String typeName);

    int update(Type record);

    int delete(String typeId);
}
