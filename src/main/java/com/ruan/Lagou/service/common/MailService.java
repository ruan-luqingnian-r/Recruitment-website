package com.ruan.Lagou.service.common;

/**
 * @Author: ruan
 * Date: 2021/12/12 0:45
 * @Description: 邮箱发送
 */
public interface MailService {
    void sendSimpleMail(String to,String subject,String content);
}
