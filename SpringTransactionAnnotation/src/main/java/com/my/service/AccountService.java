package com.my.service;

import com.my.domain.Account;

/**
 * 账户的业务层接口
 *
 * @author gjq
 * @create 2019-09-09-11:32
 */
public interface AccountService {

    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    Account findAccountById(Integer id);


    /**
     * 转账
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money      转账金额
     */
    void transfer(String sourceName, String targetName, Float money);

}
