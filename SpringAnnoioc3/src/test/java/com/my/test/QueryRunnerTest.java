package com.my.test;

import com.my.config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试QueryRunner是否是单例的
 *
 * @author gjq
 * @create 2019-09-03-20:43
 */
public class QueryRunnerTest {

    @Test
    public void test1() {
        //获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取QueryRunner对象
        QueryRunner runner = ac.getBean("runner", QueryRunner.class);
        QueryRunner runner2 = ac.getBean("runner", QueryRunner.class);
        System.out.println(runner);
        System.out.println(runner2);
    }


}
