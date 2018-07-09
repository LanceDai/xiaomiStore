package com.xiaomiStore.dao;

import com.xiaomiStore.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {
    @Insert("insert into xiaomi_order (orderId, userId, sum, createTime, status) " +
            "values (#{record.orderId}, #{record.userId}, #{record.sum}, #{record.createTime}, #{record.status})")
    int insert(@Param("record") Order record);

    @Delete("delete from xiaomi_order where orderId = #{orderId}")
    int delete(String orderId);

    @Select("select * from xiaomi_order where orderId = #{orderId}")
    Order select(String orderId);

    @Select("select * from xiaomi_order")
    List<Order> selectAll();

    @Select("SELECT createTime, sum FROM xiaomi_order ORDER BY createTime")
    @MapKey("createTime")
    Map<Timestamp, Map<String, Object>> selectTimeAndPrice();
}
