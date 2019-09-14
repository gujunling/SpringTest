package com.my.utils;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包含了开启事务，提交事务，回滚事务，释放连接。
 *
 * @author gjq
 * @create 2019-09-07-15:25
 */
public class TransactionManager {


    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
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


}
