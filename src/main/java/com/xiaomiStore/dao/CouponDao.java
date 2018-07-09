package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Coupon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CouponDao {
    @Insert("INSERT INTO xiaomi_coupon (couponId, name, price, description, status) " +
            "VALUES(#{record.couponId}, #{record.name}, #{record.price}, " +
            "#{record.description}, #{record.status})")
    int insert(@Param("record") Coupon record);

    @Delete("delete from xiaomi_coupon where couponId = #{couponId}")
    int delete(String couponId);

    @Select("select * from xiaomi_coupon")
    List<Coupon> selectAll();

    @Select("SELECT * FROM xiaomi_coupon WHERE couponId = #{couponId}")
    Coupon selectById(String couponId);

    @Update("UPDATE xiaomi_coupon SET name = #{record.name}\n" +
            ",price = #{record.price}\n" +
            ",description = #{record.description}\n" +
            ",status = #{record.status}\n" +
            "WHERE couponId = #{record.couponId}")
    int update(@Param("record")Coupon record);
}
