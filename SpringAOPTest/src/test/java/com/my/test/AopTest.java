package com.my.test;

import com.my.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP的配置
 *
 * @author gjq
 * @create 2019-09-07-22:23
 */
public class AopTest {


    public static void main(String[] args) {

        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();

    }
}
