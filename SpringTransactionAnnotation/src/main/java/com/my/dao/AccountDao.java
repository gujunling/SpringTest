package com.my.dao;

import com.my.domain.Account;

/**
 * 账户的持久层接口
 *
 * @author gjq
 * @create 2019-09-08-18:09
 */
public interface AccountDao {

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);


    /**
     * 根据名称查询账户信息
     *
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户信息
     *
     * @param account
     */
    void updateAccount(Account account);
}
