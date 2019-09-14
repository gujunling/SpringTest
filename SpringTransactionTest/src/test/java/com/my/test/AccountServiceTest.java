package com.my.test;


import com.my.service.AccountService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 使用单元测试测试配置
 *
 * @author gjq
 * @create 2019-09-03-18:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountService as;


    /**
     * 测试转账方法
     */
    @Test
    public void test1() {

        as.transfer("aaa","bbb",100f);

    }

}
