package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.po.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/syslog")
public class SysLogController {
    //注入SysLogService对象
    @Autowired
    private SysLogService sysLogService;

    /**
     * 查询所有日志
     */
    @RequestMapping("list/{pageNum}/{pageSize}")
    public String list(Model model, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        PageInfo<SysLog> pageInfo = sysLogService.findAllSysLogs(pageNum, pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("menuId","syslog");
        return "syslog-list";
    }
}
