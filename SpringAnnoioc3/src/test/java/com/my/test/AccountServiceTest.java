package com.my.test;

import com.my.config.SpringConfiguration;
import com.my.domain.Account;
import com.my.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用单元测试测试配置
 *
 * Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *             @Runwith
 *      3、告知spring的运行器，spring的ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 * @author gjq
 * @create 2019-09-03-18:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService as = null;

    /**
     * 测试查询所有的方法
     */
    @Test
    public void test1() {

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

        //执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    /**
     * 测试保存账户信息的方法
     */
    @Test
    public void test3() {

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

        //执行方法
        as.deleteAccount(4);
    }
}
