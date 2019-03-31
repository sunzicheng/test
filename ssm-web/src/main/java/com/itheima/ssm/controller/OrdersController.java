package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.Orders;
import com.itheima.ssm.po.Product;
import com.itheima.ssm.service.OrdersService;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrdersController {
    //注入订单业务逻辑层对象
    @Autowired
    private OrdersService ordersService;

    //注入商品业务逻辑层对象
    @Autowired
    private ProductService productService;

    /**
     * 查询所有订单
     */
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model,@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize){
        //调用业务查询所有订单
        PageInfo<Orders> pageInfo = ordersService.findAllOrders(pageNum,pageSize);
        // 查询全部订单列表数据
        model.addAttribute("pageInfo",pageInfo);

        // 响应当前菜单Id（order）
        model.addAttribute("menuId","order");

        return "order-list";
    }

    /**
     * 添加网页转跳
     */
    @RequestMapping("add")
    public String add(Model model){
        //转跳前要把产品列表返回
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("plist",productList);
        return "/order-add";
    }

    /**
     * 保新订单
     */
    @RequestMapping("save")
    public String save(Orders orders){
        ordersService.saveOrders(orders);
        return "redirect:/order/list";
    }

    /**
     * 转跳到跟新页面并进行数据回写
     */
    @RequestMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        //根据id查询出顶单
        Orders orders = ordersService.findOrdersById(id);
        //把结果保存到域中
        model.addAttribute("orders",orders);

        //页面转发
        return "order-update";
    }

    /**
     * 更新订单信息
     */
    @RequestMapping("update")
    public String update(Orders orders){
        //执行更新业务
        ordersService.updateOrders(orders);

        //转跳回列表页面
        return "redirect:list";
    }
}
