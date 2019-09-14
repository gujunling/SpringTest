package service.impl;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import service.AccountService;

/**
 * 账户的业务层实现类
 *
 * @author gjq
 * @create 2019-09-02-19:52
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}