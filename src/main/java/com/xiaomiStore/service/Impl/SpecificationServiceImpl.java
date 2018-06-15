package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.SpecificationDao;
import com.xiaomiStore.pojo.Specification;
import com.xiaomiStore.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationDao specificationDao;

    @Autowired
    public SpecificationServiceImpl(SpecificationDao specificationDao) {
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

    @Override
    public List<String> selectAllColorWithProduct(String productId) {
        return specificationDao.selectAllColorWithProduct(productId);
    }

    @Override
    public List<String> selectAllVersionWithProduct(String productId) {
        return specificationDao.selectAllVersionWithProduct(productId);
    }
}
