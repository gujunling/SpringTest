package com.my.service.impl;

import com.my.dao.AccountDao;
import com.my.dao.impl.AccountDaoImpl;
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

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountServiceImpl() {

    }

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


}
