package com.itheima.ssm.service;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.Role;
import com.itheima.ssm.po.User;

import java.util.List;

/**
 * 用户Service接口
 */
public interface UserService {
    /**
     * 查询全部用户列表
     */
    PageInfo<User> findAllUsers(Integer pageNum, Integer pageSize);

    /**
     * 保存用户
     */
    void saveUser(User user);

    /**
     * 根据用户id查询用户信息，并且关联查询出用户关联的角色和权限信息
     */
    User findUserById(Long id);

    /**
     * 查询所有角色
     */
    List<Role> findAllRole();

    /**
     * 删除用户角色中间表中的关系
     */
    void delUserAndRole(Long userId);

    /**
     * 保存新的用户和角色中间表关系
     */
    void addRoleToUser(Long userId, Long[] roleIds);

    /**
     * 根据用户名称查询用户
     */
    List<User> findUserByName(String userName);

}
