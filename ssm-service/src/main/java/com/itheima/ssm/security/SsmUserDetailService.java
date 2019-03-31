package com.itheima.ssm.security;

import com.itheima.ssm.po.Role;
import com.itheima.ssm.po.User;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SsmUserDetailService implements UserDetailsService {
    // 注入用户service
    @Autowired
    private UserService userService;

    /**
     * 实现逻辑：
     *      1.根据用户名称查询用户信息
     *      2.根据用户id查询角色信息
     */

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 定义角色权限集合
        List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();

        // 根据用户名称查询用户信息
        List<User> list = userService.findUserByName(s);

        // 根据用户名称查询到用户，则继续查询用户的角色
        if(list !=null && list.size()>0){
            User user = userService.findUserById(list.get(0).getId());

            // 获取角色列表
            List<Role> roleList = user.getRoleList();
            if(roleList != null && roleList.size()>0){
                for(Role r:roleList){
                    // 添加角色
                    ga.add(new SimpleGrantedAuthority(r.getRoleName()));
                }
            }

            // 创建并返回security 用户对象
            org.springframework.security.core.userdetails.User securityUser =
                    new org.springframework.security.core.userdetails.User(user.getUsername(),
                            "{MD5}"+user.getPassword(),ga);

            return securityUser;
        }
        return null;
    }
}
