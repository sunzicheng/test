package com.itheima.ssm.dao;

import com.itheima.ssm.po.Permission;

import java.util.List;

/**
 * 权力DAO接口
 */
public interface PermissionDao {
    /**
     * 查询所有权限列表
     */
    List<Permission> findAllPermission();

    /**
     * 保存新的权限
     */
    void savePermission(Permission permission);

    /**
     * 跟据ID删除权力
     */
    void delPermission(Long id);
}
