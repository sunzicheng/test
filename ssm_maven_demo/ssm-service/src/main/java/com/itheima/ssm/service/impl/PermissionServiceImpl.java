package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.PermissionDao;
import com.itheima.ssm.po.Permission;
import com.itheima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权力Service
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    //注入DAO
    @Autowired
    private PermissionDao permissionDao;
    /**
     * 查询所有权限列表
     */
    @Override
    public PageInfo<Permission> findAllPermission(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Permission> permissionList = permissionDao.findAllPermission();
        PageInfo<Permission> pageInfo = new PageInfo<>(permissionList);
        return pageInfo;
    }

    /**
     * 保存新的权限
     *
     * @param permission
     */
    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    /**
     * 跟据ID删除权力
     *
     * @param id
     */
    @Override
    public void delPermission(Long id) {
        permissionDao.delPermission(id);
    }
}
