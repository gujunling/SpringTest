package com.my.dao;

import com.my.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 *
 * @author gjq
 * @create 2019-09-03-17:20
 */
public interface AccountDao {


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
     * 根据名称查询账户信息
     *
     * @param accountName
     * @return 如果有唯一的返回结果就返回，没有结果就返回null，如果结果集超过一个就抛出异常
     */
    Account findAccountByName(String accountName);
}
