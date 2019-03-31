package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.OrdersDao;
import com.itheima.ssm.po.Orders;
import com.itheima.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    /**
     * 查询全部订单列表
     */
    @Override
    /*public List<Orders> findAllOrders() {
        return ordersDao.findAllOrders();
    }*/
    public PageInfo<Orders> findAllOrders(Integer pageNum,Integer pageSize){
        //设置分页和每页大小
        PageHelper.startPage(pageNum,pageSize);
        //调用业务查询
        List<Orders> ordersList = ordersDao.findAllOrders();
        //封装进分页对象内
        PageInfo<Orders> pageInfo =  new PageInfo<>(ordersList);

        return pageInfo;
    }

    /**
     * 保存订单
     *
     * @param orders
     */
    @Override
    public void saveOrders(Orders orders) {
        ordersDao.saveOrders(orders);
    }

    /**
     * 根据id查询订单
     *
     * @param id
     */
    @Override
    public Orders findOrdersById(Long id) {
        return ordersDao.findOrdersById(id);

    }

    /**
     * 修改订单
     *
     * @param orders
     */
    @Override
    public void updateOrders(Orders orders) {
        ordersDao.updateOrders(orders);
    }
}
