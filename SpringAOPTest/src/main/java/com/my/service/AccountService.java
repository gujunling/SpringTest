package com.my.service;

/**
 * 账户的额业务层接口
 *
 * @author gjq
 * @create 2019-09-07-21:15
 */
public interface AccountService {

    /**
     * 模拟保存账户信息
     */
    void saveAccount();

    /**
     * 模拟更新账户信息
     *
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     *
     * @return
     */
    int deleteAccount();
}
