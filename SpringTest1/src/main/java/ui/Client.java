package ui;

import factory.BeanFactory;
import service.AccountService;

/**
 * 模拟一个表现层，用于调用业务层
 *
 * @author gjq
 * @create 2019-09-02-13:48
 */
public class Client {


    public static void main(String[] args) {
        for (int i = 0; i < 5 ; i++) {
            AccountService service = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(service);
            service.saveAccount();
        }
    }

}
