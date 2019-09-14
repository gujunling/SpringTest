package com.my.service.impl;

import com.my.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 *
 * @author gjq
 * @create 2019-09-07-21:19
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {


    public void saveAccount() {

        System.out.println("执行了保存操作");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新操作"+i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除操作");
        return 0;
    }


}
