package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.ProductDao;
import com.itheima.ssm.po.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // 注入商品dao
    @Autowired
    private ProductDao productDao;

    /**
     * 查询全部商品列表
     */
    @Override
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    /**
     * 添加商品
     *
     * @param product
     */
    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    /**
     * 根据ID查询商品
     *
     * @param id
     */
    @Override
    public Product findProductById(Long id) {
        return productDao.findProductById(id);
    }

    /**
     * 修改商品保存数据库
     */
    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    /**
     * 根据商品Id删除商品
     *
     * @param id
     */
    @Override
    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }


}
