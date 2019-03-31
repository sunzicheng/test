package com.itheima.ssm.service;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.SysLog;

public interface SysLogService {
    /**
     * 查询全部日志列表
     */
    PageInfo<SysLog> findAllSysLogs(Integer pageNum, Integer pageSize);

    /**
     * 保存日志
     */
    void addSysLog(SysLog sysLog);
}
