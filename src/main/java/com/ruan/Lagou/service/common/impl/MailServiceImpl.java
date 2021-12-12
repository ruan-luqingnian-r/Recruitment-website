package com.ruan.Lagou.service.common.impl;

import com.ruan.Lagou.service.common.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author: ruan
 * Date: 2021/12/12 0:46
 * @Description:
 */
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        //创建邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);//设置发件人
        message.setSubject(subject);//设置邮件主体
        message.setText(content);//设置右键内容
        message.setTo(to);//设置接收方
        //发送
        mailSender.send(message);
        log.info("邮件发送成功:{}",message.toString());

    }
}
