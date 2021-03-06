package com.my.test;

import com.my.domain.Account;
import com.my.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用单元测试测试配置
 *
 * @author gjq
 * @create 2019-09-03-18:11
 */
public class AccountServiceTest {


    /**
     * 测试查询所有的方法
     */
    @Test
    public void test1() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    /**
     * 测试根据id查询的方法
     */
    @Test
    public void test2() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    /**
     * 测试保存账户信息的方法
     */
    @Test
    public void test3() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        Account account = new Account();
        account.setName("贱人");
        account.setMoney(2000f);
        as.saveAccount(account);

    }

    /**
     * 测试更新账户信息的方法
     */
    @Test
    public void test4() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        Account account = new Account();
        account.setId(4);
        account.setName("骚货");
        account.setMoney(2000f);
        as.updateAccount(account);
    }

    /**
     * 测试删除账户信息的方法
     */
    @Test
    public void test5() {
        //获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //得到业务层对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        //执行方法
        as.deleteAccount(4);
    }
}
