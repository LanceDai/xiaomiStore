package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.CouponDao;
import com.xiaomiStore.pojo.Coupon;
import com.xiaomiStore.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {
    private final CouponDao couponDao;

    @Autowired
    public CouponServiceImpl(CouponDao couponDao) {
        this.couponDao = couponDao;
    }

    @Override
    public int insert(Coupon record) {
        return couponDao.insert(record);
    }

    @Override
    public int delete(String couponId) {
        return couponDao.delete(couponId);
    }

    @Override
    public List<Coupon> selectAll() {
        return couponDao.selectAll();
    }

    @Override
    public Coupon selectById(String couponId) {
        return couponDao.selectById(couponId);
    }

    @Override
    public int update(Coupon record) {
        return couponDao.update(record);
    }
}
