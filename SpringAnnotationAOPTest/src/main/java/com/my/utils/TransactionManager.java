package com.my.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 和事务管理相关的工具类，包含了开启事务，提交事务，回滚事务，释放连接。
 *
 * @author gjq
 * @create 2019-09-07-15:25
 */
@Component("txManager")
@Aspect  //表明当前类是切面类
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.my.service.impl.*.*(..))")
    private void pt1() {

    }

    /**
     * 开启事务的方法
     */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务的方法
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务的方法
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接的方法
     */
    public void release() {
        try {
            //close()方法是将连接还回连接池中
            connectionUtils.getThreadConnection().close();
            //进行解绑
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            //获取参数
            Object[] args = pjp.getArgs();
            //开启事务
            this.beginTransaction();
            //执行方法
            rtValue = pjp.proceed(args);
            //提交事务
            this.commit();
            //返回结果
            return rtValue;
        } catch (Throwable throwable) {
            //回滚事务
            this.rollback();
            throw new RuntimeException(throwable);
        } finally {
            //释放资源
            this.release();
        }
    }


}
