package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.dao.SysLogDao;
import com.itheima.ssm.po.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysLogServiceImpl implements SysLogService {
    //注入SysLogDao
    @Autowired
    private SysLogDao sysLogDao;
    /**
     * 查询全部日志列表
     */
    @Override
    public PageInfo<SysLog> findAllSysLogs(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SysLog> logList = sysLogDao.findAllSysLogs();
        PageInfo<SysLog> pageInfo = new PageInfo<>(logList);
        return pageInfo;
    }

    /**
     * 保存日志
     *
     * @param sysLog
     */
    @Override
    public void addSysLog(SysLog sysLog) {
        sysLogDao.addSysLog(sysLog);
    }
}
