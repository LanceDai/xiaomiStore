package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.SpecificationDao;
import com.xiaomiStore.pojo.Specification;
import com.xiaomiStore.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpecificationImpl implements SpecificationService {

    private final SpecificationDao specificationDao;

    @Autowired
    public SpecificationImpl(SpecificationDao specificationDao) {
        this.specificationDao = specificationDao;
    }

    @Override
    public int insert(Specification record) {
        return specificationDao.insert(record);
    }

    @Override
    public int delete(String colorId, String productId, String versionId) {
        return specificationDao.delete(colorId, productId, versionId);
    }

    @Override
    public int update(Specification record) {
        return specificationDao.update(record);
    }

    @Override
    public Specification select(String colorId, String productId, String versionId) {
        return specificationDao.select(colorId, productId, versionId);
    }

    @Override
    public List<Specification> selectAll() {
        return specificationDao.selectAll();
    }
}
