package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
    @Insert("insert into xiaomi_order (orderId, userId, sum, createTime) " +
            "values (#{record.orderID}, #{record.userID}, #{record.sum}, #{record.createTime})")
    int insert(@Param("record") Order record);

    @Delete("delete from xiaomi_order where orderId = #{orderId}")
    int delete(int orderId);

    @Select("select * from xiaomi_order where orderId = #{orderId}")
    Order select(int orderId);

    @Select("select * from xiaomi_order")
    List<Order> selectAll();
}
