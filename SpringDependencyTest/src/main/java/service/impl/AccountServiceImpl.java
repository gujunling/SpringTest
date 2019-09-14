package service.impl;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import service.AccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 *
 * @author gjq
 * @create 2019-09-02-19:52
 */
public class AccountServiceImpl implements AccountService {

    //如果是经常变化的数据，不适用与注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public void saveAccount() {

        System.out.println("service中的saveAccount方法执行了，" + name + "," + age + "," + birthday);
    }
}