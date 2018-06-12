package com.xiaomiStore.service.Impl;

import com.xiaomiStore.dao.OrderDao;
import com.xiaomiStore.pojo.Order;
import com.xiaomiStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{

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
    public int delete(int orderId) {
        return orderDao.delete(orderId);
    }

    @Override
    public Order select(int orderId) {
        return orderDao.select(orderId);
    }

    @Override
    public List<Order> selectAll() {
        return orderDao.selectAll();
    }
}
