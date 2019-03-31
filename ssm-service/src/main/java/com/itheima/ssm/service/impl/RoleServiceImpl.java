package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.RoleDao;
import com.itheima.ssm.po.Permission;
import com.itheima.ssm.po.Role;
import com.itheima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    //注入RoleDao对象
    private RoleDao roleDao;
    /**
     * 查询所有角色
     */
    @Override
    public PageInfo<Role> findAllRole(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Role> rolelist = roleDao.findAllRole();

        PageInfo<Role> pageInfo = new PageInfo<>(rolelist);

        return pageInfo;
    }

    /**
     * 保存新角色
     *
     * @param role
     */
    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    /**
     * 根据id查询出角色
     *
     * @param id
     */
    @Override
    public Role findRoleById(Long id) {
        return roleDao.findRoleById(id);
    }

    /**
     * 查询出所有的权限
     */
    @Override
    public List<Permission> findAllPermission() {
        return roleDao.findAllPermission();
    }

    /**
     * 删除角色与权力关系的中间表
     *
     * @param roleId
     */
    @Override
    public void delRoleAndPermission(Long roleId) {
        roleDao.delRoleAndPermission(roleId);
    }

    /**
     * 保存新的角色与权力的关系
     *
     * @param
     */
    @Override
    public void addRoleAndPermission(Long roleId ,Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            Long[] tmparr = {roleId, ids[i]};
            roleDao.addRoleAndPermission(tmparr);
        }
    }

}
