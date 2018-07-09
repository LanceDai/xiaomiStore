package com.xiaomiStore.service;

import com.xiaomiStore.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderService {

    public int insert(Order record);

    public int delete(String orderId);

    public Order select(String orderId);

    public List<Order> selectAll();

    public List<Map<String, String>> selectTimeAndPrice();
}
