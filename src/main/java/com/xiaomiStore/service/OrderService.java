package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderService {

    public int insert(@Param("record") Order record);

    public int delete(int orderId);

    public Order select(int orderId);

    public List<Order> selectAll();
}
