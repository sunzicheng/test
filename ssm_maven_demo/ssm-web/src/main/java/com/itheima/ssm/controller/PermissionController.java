package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.Permission;
import com.itheima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权力controller
 */
@Controller
@RequestMapping("permission")
public class PermissionController {
    //注入Service
    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有的权力
     */
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        PageInfo<Permission> pageInfo = permissionService.findAllPermission(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("menuId","permission");
        return  "permission-list";
    }

    /**
     * 跳转到新建页面
     */
    @RequestMapping("add")
    public String add(){
        return "permission-add";
    }

    /**
     * 保存新的权力
     */
    @RequestMapping("save")
    public String savePermission(Permission permission){
        permissionService.savePermission(permission);
        return "redirect:list/1/5";
    }

    /**
     * 根据Id删除权力
     */
    @RequestMapping("del/{id}")
    public String delPermission(@PathVariable("id") Long id){
        permissionService.delPermission(id);
        return "redirect:/permission/list/1/5";
    }
}
