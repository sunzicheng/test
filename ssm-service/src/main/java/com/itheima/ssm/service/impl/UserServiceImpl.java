package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.UserDao;
import com.itheima.ssm.po.Role;
import com.itheima.ssm.po.User;
import com.itheima.ssm.service.UserService;
import com.itheima.ssm.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //注入UserDao对象
    @Autowired
    private UserDao userDao;

    /**
     * 查询全部用户列表
     */
    @Override
    public PageInfo<User> findAllUsers(Integer pageNum, Integer pageSize) {
        //设置分页
        PageHelper.startPage(pageNum,pageSize);

        List<User> userList = userDao.findAllUsers();
        //分装
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
     * 保存用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        //密码加密
        String password = user.getPassword();
        String md5 = MD5Util.md5(password);
        //更新到数据库
        user.setPassword(md5);
        //保存用户
        userDao.saveUser(user);
    }

    /**
     * 根据用户id查询用户信息，并且关联查询出用户关联的角色和权限信息
     *
     * @param id
     */
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    /**
     * 查询所有角色
     */
    @Override
    public List<Role> findAllRole() {
        return userDao.findAllRole();
    }

    /**
     * 删除用户角色中间表中的关系
     *
     * @param userId
     */
    @Override
    public void delUserAndRole(Long userId) {
        userDao.delUserAndRole(userId);
    }

    /**
     * 保存新的用户和角色中间表关系
     */
    @Override
    public void addRoleToUser(Long userId, Long[] roleIds) {
        for (int i = 0; i < roleIds.length; i++) {
            Long[] tmpIds = {userId,roleIds[i]};
            userDao.addRoleToUser(tmpIds);
        }
    }

    /**
     * 根据用户名称查询用户
     *
     * @param userName
     */
    @Override
    public List<User> findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

}
