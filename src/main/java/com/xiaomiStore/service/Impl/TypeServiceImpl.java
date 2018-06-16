package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.TypeDao;
import com.xiaomiStore.pojo.Type;
import com.xiaomiStore.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeDao typeDao;

    @Autowired
    public TypeServiceImpl(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    public int insert(Type record) {
        return typeDao.insert(record);
    }

    @Override
    public List<Type> selectAll() {
        return typeDao.selectAll();
    }

    @Override
    public Type selectByPrimaryKey(String typeId) {
        return typeDao.selectByPrimaryKey(typeId);
    }

    @Override
    public List<Type> selectByParentId(String parentId) {
        return typeDao.selectByParentId(parentId);
    }

    @Override
    public Type selectByName(String typeName) {
        return typeDao.selectByName(typeName);
    }

    @Override
    public int update(Type record) {
        return typeDao.update(record);
    }

    @Override
    public int delete(String typeId) {
        return typeDao.delete(typeId);
    }

    @Override
    public String getTypeIdByTypeName(String typeName) {
        return typeDao.getTypeIdByTypeName(typeName);
    }

}
