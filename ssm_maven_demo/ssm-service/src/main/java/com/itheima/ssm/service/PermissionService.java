package com.itheima.ssm.service;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.Permission;

public interface PermissionService {

    /**
     * 查询所有权限列表
     */
    PageInfo<Permission> findAllPermission(Integer pageNum, Integer pageSize);

    /**
     * 保存新的权限
     */
    void savePermission(Permission permission);

    /**
     * 跟据ID删除权力
     */
    void delPermission(Long id);
}
