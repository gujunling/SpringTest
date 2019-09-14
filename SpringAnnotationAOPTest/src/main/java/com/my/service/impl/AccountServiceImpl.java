package com.my.service.impl;

import com.my.dao.AccountDao;
import com.my.domain.Account;
import com.my.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 账户的业务层实现类
 *
 * @author gjq
 * @create 2019-09-03-17:31
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();

    }


    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }


    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }


    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }


    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);
//        int i = 1 / 0;
        //2.6更新转入账户
        accountDao.updateAccount(target);
    }


}
