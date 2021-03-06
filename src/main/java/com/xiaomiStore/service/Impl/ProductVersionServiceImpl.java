package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.ProductVersionDao;
import com.xiaomiStore.pojo.ProductVersion;
import com.xiaomiStore.service.ProductVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVersionServiceImpl implements ProductVersionService {
    private final ProductVersionDao productVersionDao;

    @Autowired
    public ProductVersionServiceImpl(ProductVersionDao productVersionDao) {
        this.productVersionDao = productVersionDao;
    }

    @Override
    public int insert(ProductVersion record) {
        return productVersionDao.insert(record);
    }

    @Override
    public int delete(String versionId) {
        return productVersionDao.delete(versionId);
    }

    @Override
    public int update(ProductVersion record) {
        return productVersionDao.update(record);
    }

    @Override
    public ProductVersion select(String versionId) {
        return productVersionDao.select(versionId);
    }

    @Override
    public List<ProductVersion> selectAll() {
        return productVersionDao.selectAll();
    }

    @Override
    public String getDetailVersionByVersionId(String versionId) {
        return productVersionDao.getDetailVersionByVersionId(versionId);
    }

    @Override
    public String getVersionIdByDetailVersion(String detailVersion) {
        return productVersionDao.getVersionIdByDetailVersion(detailVersion);
    }
}
