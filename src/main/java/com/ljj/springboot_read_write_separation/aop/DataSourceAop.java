package com.ljj.springboot_read_write_separation.aop;

import com.ljj.springboot_read_write_separation.bean.DBContextHolder;
import com.ljj.springboot_read_write_separation.enums.DBTypeEnum;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: ljj
 * @Date: 2019/9/10 15:45
 * @Description:
 */
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.ljj.springboot_read_write_separation.annotation.Master) " +
            "&& (execution(* com.ljj.springboot_read_write_separation.service..*.select*(..)) " +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.get*(..)) " +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.find*(..)))")
    public void readPointcut(){}

    @Pointcut("@annotation(com.ljj.springboot_read_write_separation.annotation.Master)" +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.insert*(..))" +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.add*(..))" +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.update*(..))" +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.edit*(..))" +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.delete*(..))" +
            "|| execution(* com.ljj.springboot_read_write_separation.service..*.remove*(..))")
    public void writePointcut(){}

    @Before("readPointcut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write(){
        DBContextHolder.master();
    }
}
