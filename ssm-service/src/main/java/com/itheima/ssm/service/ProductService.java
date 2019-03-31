package com.itheima.ssm.service;

import com.itheima.ssm.po.Product;

import java.util.List;

/**
 * 商品service接口
 */
public interface ProductService {
    /**
     * 查询全部商品列表
     */
    List<Product> findAllProducts();

    /**
     * 添加商品
     */
    void saveProduct(Product product);

    /**
     * 根据ID查询商品
     */
    Product findProductById(Long id);

    /**
     * 修改商品保存数据库
     */
    void updateProduct(Product product);

    /**
     * 根据商品Id删除商品
     */
    void deleteProduct(Long id);
}
