package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.Role;
import com.itheima.ssm.po.User;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //注入UserService对象
    @Autowired
    private UserService userService;
    //注入UserService对象
    @Autowired
    private UserService rserService;

    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize){
        PageInfo<User> pageInfo = userService.findAllUsers(pageNum, pageSize);
        //传送数据
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("menuId","user");

        return "user-list";
    }

    /**
     * 转跳到添加页面
     */
    @RequestMapping("add")
    public String add(){
        return "user-add";
    }

    /**
     * 保存用户
     *
     * @param user
     */
    @RequestMapping("save")
    public String saveUser(User user){
        userService.saveUser(user);
        return "redirect:/user/list/1/5";
    }

    /**
     * 查询用户
     */
    @RequestMapping("show/{id}")
    public String showUser(Model model,@PathVariable("id") long id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);

        return "user-show";
    }

    /**
     * 转跳到角色分配页面
     */
    @RequestMapping("roleAdd/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        //获取角色列表
        List<Role> roleList = userService.findAllRole();

        //根据Id查询用户
        User user = userService.findUserById(id);

        // 设置角色是否需要选中
        List<Role> userRoleList = user.getRoleList();
        for(Role role:roleList){
            for(Role ur:userRoleList){
                // 如果角色列表中有用户对应的角色，则设置checkbok=1
                if(role.getId()==ur.getId()){
                    role.setChecked(1);
                    break;
                }
            }
        }


        //放回角色列表与用户
        model.addAttribute("roleList",roleList);
        model.addAttribute("user",user);

        return "user-role-add";
    }

    /**
     * 保存用户与角色的新关系
     */
    @RequestMapping("addRoleToUser")
    public String addRoleToUser(Long userId, Long[] ids){

        //删除用户与角色表之间的关系
        userService.delUserAndRole(userId);

        //添加新的用户与角色关系
        userService.addRoleToUser(userId,ids);

        return "redirect:/user/list/1/5";
    }
}
