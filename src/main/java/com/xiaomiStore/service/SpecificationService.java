package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Specification;

import java.util.List;

public interface SpecificationService {

    int insert(Specification record);

    int delete(String colorId, String productId, String versionId);

    int update(Specification record);

    Specification select(String colorId, String productId, String versionId);

    List<Specification> selectAll();

    List<String> selectAllColorWithProduct(String productId);


    List<String> selectAllVersionWithProduct(String productId);

}
