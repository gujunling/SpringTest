package com.my.cglib;


/**
 * 生产者
 *
 * @author gjq
 * @create 2019-09-07-18:37
 */
public class Producer {


    /**
     * 销售产品
     *
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("出售产品，并得到钱" + money);
    }

    /**
     * 售后服务
     *
     * @param money
     */
    public void afterService(float money) {
        System.out.println("进行售后服务，并得到钱" + money);
    }
}
