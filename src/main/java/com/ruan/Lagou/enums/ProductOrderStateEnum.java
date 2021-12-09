package com.ruan.Lagou.enums;

/**
 * @Author: ruan
 * Date: 2021/8/2 18:43
 * @Description: 支付状态枚举类
 */
public enum ProductOrderStateEnum {
    /**
     * 未支付订单
     */
    NEW,


    /**
     * 已经支付订单
     */
    PAY,

    /**
     * 超时取消订单
     */
    CANCEL;
}
