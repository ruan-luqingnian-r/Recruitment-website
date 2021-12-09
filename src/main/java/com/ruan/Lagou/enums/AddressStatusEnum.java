package com.ruan.Lagou.enums;

/**
 * @Author: ruan
 * Date: 2021/7/29 22:10
 * @Description: 收货地址状态
 */
public enum AddressStatusEnum {

    /**
     * 默认收货地址
     */
    DEFAULT_STATUS(1),

    /**
     * 常规收货地址
     */
    COMMON_STATUS(0);

    private int status;

    private AddressStatusEnum(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
