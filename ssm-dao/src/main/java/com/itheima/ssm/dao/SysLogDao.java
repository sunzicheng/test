package com.itheima.ssm.dao;

import com.itheima.ssm.po.SysLog;

import java.util.List;

public interface SysLogDao {
    /**
     * 查询全部日志列表
     */
    List<SysLog> findAllSysLogs();

    /**
     * 保存日志
     */
    void addSysLog(SysLog sysLog);
}
