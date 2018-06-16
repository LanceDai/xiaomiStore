package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.ColorDao;
import com.xiaomiStore.dao.ProductVersionDao;
import com.xiaomiStore.dao.SpecificationDao;
import com.xiaomiStore.pojo.Specification;
import com.xiaomiStore.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service

public class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationDao specificationDao;
    private final ProductVersionDao productVersionDao;
    private final ColorDao colorDao;

    @Autowired
    public SpecificationServiceImpl(SpecificationDao specificationDao, ProductVersionDao productVersionDao, ColorDao colorDao) {
        this.specificationDao = specificationDao;
        this.productVersionDao = productVersionDao;
        this.colorDao = colorDao;
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
    public Map<String, String> selectAllColorWithProduct(String productId) {
        List<String> list = specificationDao.selectAllColorWithProduct(productId);
        Map<String, String> stringStringMap = new HashMap<>();
        for (String str : list) {
            stringStringMap.put(str, colorDao.getColorNameByColorId(str));
        }
        return stringStringMap;
    }

    @Override
    public Map<String, String> selectAllVersionWithProduct(String productId) {
        Map<String, Map<String, String>> map = specificationDao.selectAllVersionWithProduct(productId);
        Map<String, String> stringStringMap = new HashMap<>();
        Set<String> keySet = map.keySet();

        for (String str : keySet) {
            stringStringMap.put(
                    productVersionDao.getDetailVersionByVersionId(str), map.get(str).get("price"));
        }
        return stringStringMap;
    }

    @Override
    public String getMinPriceByProductId(String productId) {
        return specificationDao.getMinPriceByProductId(productId);
    }
}
