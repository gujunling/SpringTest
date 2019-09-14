package com.my.proxy;

/**
 * 对生产厂家要求的接口
 *
 * @author gjq
 * @create 2019-09-07-18:43
 */
public interface IProducer {

    /**
     * 销售产品
     */
    void saleProduct(float money);

    /**
     * 售后服务
     */
    void afterService(float money);
}
