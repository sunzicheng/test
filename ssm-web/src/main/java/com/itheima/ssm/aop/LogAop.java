package com.itheima.ssm.aop;

import com.itheima.ssm.po.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component("logAop")
@Aspect
public class LogAop {
    // 目标对象的字节码对象Clazz
    private Class clazz;

    // 当前访问的方法名称
    private String methodName;

    // 日志Service
    @Autowired
    private SysLogService sysLogService;

    // 请求HttpServletRequest对象
    @Autowired
    private HttpServletRequest request;

    /**
     * 前置增强：前置通知
     */
    @Before("execution(* com.itheima.ssm.controller..*.*(..))")
    public void beforeLog(JoinPoint pjp){
        // 获取目标对象
        clazz = pjp.getTarget().getClass();

        // 获取类名称
        String className = clazz.getName();

        // 获取方法名称
        methodName = pjp.getSignature().getName();
        methodName = className+"."+methodName;

        // System.out.println(methodName);
    }

    /**
     * 后置增强：最终通知
     */
    @After("execution(* com.itheima.ssm.controller..*.*(..))")
    public void afterLog(){

        // 创建日志对象
        SysLog sysLog = new SysLog();

        // 设置方法名称
        sysLog.setMethod(methodName);

        // 设置ip地址
        sysLog.setIp(request.getRemoteAddr());

        // 设置时间
        sysLog.setVisitTime(new Date());

        // 设置用户名称，细节：用户名称通过spring security获取
        // 获取上下文
        SecurityContext securityContext = SecurityContextHolder.getContext();

        // 获取认证对象
        Authentication authentication = securityContext.getAuthentication();

        // 获取主角Principal（用户）  注意类型
        User principal =(User) authentication.getPrincipal();
        sysLog.setUsername(principal.getUsername());

        // 保存日志
        sysLogService.addSysLog(sysLog);
    }

}

