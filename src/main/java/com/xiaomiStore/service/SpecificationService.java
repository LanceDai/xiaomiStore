package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Specification;

import java.util.List;
import java.util.Map;

public interface SpecificationService {

    int insert(Specification record);

    int delete(String colorId, String productId, String versionId);

    int update(Specification record);

    Specification select(String colorId, String productId, String versionId);

    List<Specification> selectAll();

    Map<String, String> selectAllColorWithProduct(String productId);


    Map<String, String> selectAllVersionWithProduct(String productId);

    String getMinPriceByProductId(String productId);

    double getPriceBySpecificationId(int specificationId);

    int getSpecificationIdByProductIdAndColorIdAndVersionId(
            String productId, String versionId, String colorId);

    String getColorNameBySpecificationId(int specificationId);

    String getDetailVersionBySpecificationId(int specificationId);

    String getProductNameBySpecificationId(int specificationId);
}
