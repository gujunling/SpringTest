package com.my.service.impl;

import com.my.dao.AccountDao;
import com.my.domain.Account;
import com.my.service.AccountService;

/**
 * @author gjq
 * @create 2019-09-09-11:39
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {

        System.out.println("transfer....");
        //1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //5.更新转出账户
        accountDao.updateAccount(source);
//        int i = 1 / 0;
        //6.更新转入账户
        accountDao.updateAccount(target);
    }
}
