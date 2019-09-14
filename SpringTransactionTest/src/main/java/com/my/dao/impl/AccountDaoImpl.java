package com.my.dao.impl;

import com.my.dao.AccountDao;
import com.my.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * 账户的持久层接口实现类
 *
 * @author gjq
 * @create 2019-09-08-18:12
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {



    /**
     * 根据id查询账户信息
     *
     * @param id
     * @return
     */
    public Account findAccountById(Integer id) {

        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    /**
     * 根据名称查询账户信息
     *
     * @param name
     * @return
     */
    public Account findAccountByName(String name) {

        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    /**
     * 更新账户信息
     *
     * @param account
     */
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name = ? ,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

}
