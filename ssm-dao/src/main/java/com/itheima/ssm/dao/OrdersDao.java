package com.itheima.ssm.dao;

import com.itheima.ssm.po.Orders;

import java.util.List;

/**
 * 订单dao接口
 */
public interface OrdersDao {
    /**
     * 查询全部订单列表
     */
    List<Orders> findAllOrders();

    /**
     * 保存订单
     */
    void saveOrders(Orders orders);

    /**
     * 根据id查询订单
     */
    Orders findOrdersById(Long id);

    /**
     * 修改订单
     */
    void updateOrders(Orders orders);
}
