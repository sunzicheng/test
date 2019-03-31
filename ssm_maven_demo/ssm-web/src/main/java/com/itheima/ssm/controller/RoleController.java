package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.Permission;
import com.itheima.ssm.po.Role;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    //注入RoleService
    @Autowired
    private RoleService roleService;
    /**
     * 查询所有角色列表
     */
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        PageInfo<Role> pageInfo = roleService.findAllRole(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("menuId","role");
        return "role-list";
    }

    /**
     * 转跳到新增页面
     */
    @RequestMapping("add")
    public String add(){
        return "role-add";
    }

    /**
     * 保存新角色
     */
    @RequestMapping("save")
    public String saveRole(Role role){
        roleService.saveRole(role);
        return "redirect:list/1/5";
    }

    /**
     * 跳转页面，展示权力列表，并查询出对应角色返回
     */
    @RequestMapping("permissionAdd/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        Role role = roleService.findRoleById(id);
        List<Permission> permissionList = roleService.findAllPermission();

        List<Permission> list = role.getPermissionList();
        for(Permission p:permissionList){
            // 判断权限集合中，与角色的权限集合，是否有相同的。有则设置为选中
            for(Permission rp:list){
                if(p.getId()==rp.getId()){
                    p.setChecked(1);
                    break;
                }
            }
        }
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }

    /**
     * 保存新的权力
     */
    @RequestMapping("addPermissionToRole")
    public String addPermissionToRole(Long roleId ,Long[] ids){
        //删除原有关系
        roleService.delRoleAndPermission(roleId);
        //新增关系
        roleService.addRoleAndPermission(roleId,ids);
        return "redirect:list/1/5";
    }
}
