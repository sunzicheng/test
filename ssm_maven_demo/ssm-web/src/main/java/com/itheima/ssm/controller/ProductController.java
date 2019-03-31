package com.itheima.ssm.controller;

import com.itheima.ssm.po.Product;
import com.itheima.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    //注入service对象
    @Autowired
    private ProductService productService;

    //查询所有商品
    @RequestMapping("list")
    public String list(Model model) {
        //调用业务方法获取商品集合
        List<Product> productList = productService.findAllProducts();
        model.addAttribute("productList", productList);

        //响应菜单id（product）
        model.addAttribute("menuId", "product");

        return "product-list";
    }

    /**
     * 跳转到添加商品页面
     */
    @RequestMapping("add")
    public String add() {
        return "product-add";
    }

    /**
     * 保存对象
     *
     * @param product
     * @return
     */
    @RequestMapping("save")
    public String save(Product product) {
        // 1.保存商品
        productService.saveProduct(product);

        return "redirect:/product/list";

    }

    /**
     * 转跳到更新页面(数据回写)
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        //根据商品id查询商品
        Product product = productService.findProductById(id);

        model.addAttribute("product", product);
        return "product-update";
    }

    /**
     * 修改商品，保存数据库
     */
    @RequestMapping("update")
    public String update(Product product) {
        // 1.保存商品
        productService.updateProduct(product);

        return "redirect:/product/list";
    }

    /**
     * 查看商品
     */
    @RequestMapping("show/{id}")
    public String show(Model model,@PathVariable("id") Long id){

        // 1.根据商品Id查询商品
        Product product = productService.findProductById(id);
        model.addAttribute("product",product);

        return "product-show";
    }

    /**
     * 删除商品
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable("id") long id){
        //调用业务删除
        productService.deleteProduct(id);

        //响应数据
        return "redirect:/product/list";
    }
}