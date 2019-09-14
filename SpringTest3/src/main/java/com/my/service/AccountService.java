package com.my.service;

import com.my.domain.Account;

import java.util.List;

/**
 * 账户的业务层
 *
 * @author gjq
 * @create 2019-09-03-17:19
 */
public interface AccountService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 添加账户
     *
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户信息
     *
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户信息
     *
     * @param id
     */
    void deleteAccount(Integer id);


    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);

}
