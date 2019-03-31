package com.itheima.ssm.dao;

import com.itheima.ssm.po.Permission;
import com.itheima.ssm.po.Role;

import java.util.List;

/**
 * 角色DAO接口
 */
public interface RoleDao {
    /**
     * 查询所有角色
     */
    List<Role> findAllRole();

    /**
     * 保存新角色
     */
    void saveRole(Role role);

    /**
     * 根据id查询出角色
     */
    Role findRoleById(Long id);

    /**
     * 查询出所有的权限
     */
    List<Permission> findAllPermission();

    /**
     * 删除角色与权力关系的中间表
     */
    void delRoleAndPermission(Long roleId);

    /**
     * 保存新的角色与权力的关系
     */
    void addRoleAndPermission(Long[] roleAndPermissionId);
}
