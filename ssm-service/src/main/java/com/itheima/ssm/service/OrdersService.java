package com.itheima.ssm.service;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 查询全部订单列表
     */
//    List<Orders> findAllOrders();
    PageInfo<Orders> findAllOrders(Integer pageNum, Integer pageSize);
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
