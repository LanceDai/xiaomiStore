package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponService {

    int insert(@Param("record") Coupon record);

    int delete(String couponId);

    List<Coupon> selectAll();
}
