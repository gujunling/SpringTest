package com.my.ui;


import com.my.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.my.service.AccountService;


/**
 * 模拟一个表现层，用于调用业务层
 *
 * @author gjq
 * @create 2019-09-02-19:53
 */
public class Client {


    public static void main(String[] args) {

        //获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //根据id获取bean对象
        AccountService service = (AccountService) ac.getBean("accountService");
        AccountDao accountDao = (AccountDao) ac.getBean("accountDao", AccountDao.class);

        System.out.println(service);
        System.out.println(accountDao);
        service.saveAccount();
    }

}
