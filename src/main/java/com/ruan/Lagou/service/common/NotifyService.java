package com.ruan.Lagou.service.common;

import com.ruan.Lagou.enums.SendCodeEnum;
import com.ruan.Lagou.util.JsonData;

/**
 * @Author: ruan
 * Date: 2021/12/12 0:00
 * @Description: 服务通知
 */
public interface NotifyService {
    /**
     * 发送验证码
     * @param sendCodeType
     * @param to
     * @return
     */
    JsonData sendCode(SendCodeEnum sendCodeType, String to);

    /**
     * 验证验证码
     */
    boolean checkCode(SendCodeEnum sendCodeEnum,String to,String code);
}
