package service.impl;

import dao.AccountDao;
import factory.BeanFactory;
import service.AccountService;

/**
 * 账户的业务层实现类
 *
 * @author gjq
 * @create 2019-09-02-13:39
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
