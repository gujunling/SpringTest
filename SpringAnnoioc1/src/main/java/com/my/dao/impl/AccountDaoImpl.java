package com.my.dao.impl;

import com.my.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 *
 * @author gjq
 * @create 2019-09-02-19:50
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {

        System.out.println("保存账户信息成功");
    }
}
