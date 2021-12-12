package com.ruan.Lagou.service.common.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ruan.Lagou.constant.CacheKey;
import com.ruan.Lagou.enums.BizCodeEnum;
import com.ruan.Lagou.enums.SendCodeEnum;
import com.ruan.Lagou.service.common.MailService;
import com.ruan.Lagou.service.common.NotifyService;
import com.ruan.Lagou.util.CheckUtil;
import com.ruan.Lagou.util.CommonUtil;
import com.ruan.Lagou.util.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ruan
 * Date: 2021/12/12 0:31
 * @Description:
 */
@Slf4j
@Service
public class NotifyServiceImpl implements NotifyService {

    private static final String SUBJECT = "【苞米招聘】验证码";
    private static final String CONTENT = "尊敬的用户,您好:\n"
            + "\n本次请求的邮件验证码为:【%s】,本验证码1分钟内有效，请及时输入。（请勿泄露此验证码）\n"
            + "\n如非本人操作，请忽略该邮件。";


    @Autowired
    private MailService mailService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 发送验证码
     * @param sendCodeType
     * @param to
     * @return
     */
    @Override
    public JsonData sendCode(SendCodeEnum sendCodeType, String to) {
        //拼装验证码检查key
        String cacheKey = String.format(CacheKey.CHECK_CODE_KEY,sendCodeType.name(),to);

        String cacheValue = redisTemplate.opsForValue().get(cacheKey);

        //为空正常执行
        if (StringUtils.isNotBlank(cacheValue)){
            //不为空
            long ttl = Long.parseLong(cacheValue.split("_")[1]);
            //当前时间戳-发送时间戳，如果小于60s则不发送
            if (CommonUtil.getCurrentTimestamp() - ttl < (1000 * 60)){
                log.info("重复发送验证码,时间间隔:{} 秒",(CommonUtil.getCurrentTimestamp()-ttl)/1000);
                return JsonData.buildResult(BizCodeEnum.CODE_LIMITED);
            }

        }
        //拼接验证码
        String code = CommonUtil.getRandomCode(6);
        String value = code+"_"+ CommonUtil.getCurrentTimestamp();
        redisTemplate.opsForValue().set(cacheKey,value,10, TimeUnit.MINUTES);
        if (CheckUtil.isEmail(to)){
            mailService.sendSimpleMail(to,SUBJECT,String.format(CONTENT, code));
            return JsonData.buildSuccess();
        }else if (CheckUtil.isPhone(to)){
            //TODO
            //短信验证码
        }
        return JsonData.buildResult(BizCodeEnum.CODE_TO_ERROR);
    }

    /**
     * 验证验证码
     */
    @Override
    public boolean checkCode(SendCodeEnum sendCodeEnum, String to, String code) {
        return false;
    }
}
