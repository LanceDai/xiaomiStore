package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.OrderDao;
import com.xiaomiStore.pojo.Order;
import com.xiaomiStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int insert(Order record) {
        return orderDao.insert(record);
    }

    @Override
    public int delete(String orderId) {
        return orderDao.delete(orderId);
    }

    @Override
    public Order select(String orderId) {
        return orderDao.select(orderId);
    }

    @Override
    public List<Order> selectAll() {
        return orderDao.selectAll();
    }

    @Override
    public List<Map<String, String>> selectTimeAndPrice() {
        //构造链式哈希表，以保证哈希表内有序
        Map<String, Integer> map = new LinkedHashMap<>();
        //从数据库得到记录
        Map<Timestamp, Map<String, Object>> timestampMapMap = orderDao.selectTimeAndPrice();
        System.out.println("result = " + timestampMapMap);
        //根据map的键集合进行遍历，处理数据
        TreeSet<Timestamp> timestamps = new TreeSet<>(timestampMapMap.keySet());
        System.out.println("timestamps = " + timestamps);
        for (Timestamp time : timestamps) {
            String date = time.getMonth() + 1 + "月" + time.getDate() + "日";
            //构造正确的日期
            map.put(date, (Integer) timestampMapMap.get(time).get("sum"));
        }
        List<Map<String, String>> list = new ArrayList<>();
        //将处理好的数据加入List
        for (String str : map.keySet()) {
            Map<String, String> stringStringMap = new LinkedHashMap<>();
            stringStringMap.put("buyTime", str);
            stringStringMap.put("price", String.valueOf(map.get(str)));
            list.add(stringStringMap);
        }
        return list;
    }
}
