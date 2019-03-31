package com.itheima.ssm.dao;

import com.itheima.ssm.po.Product;

import java.util.List;

/**
 * 商品dao接口
 */
public interface ProductDao {
    /**
     * 查询所有商品
     */
    List<Product> findAllProducts();

    /**
     * 添加商品
     */
    void saveProduct(Product product);

    /**
     * 根据商品Id查询商品
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
