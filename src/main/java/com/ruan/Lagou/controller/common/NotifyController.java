package com.ruan.Lagou.controller.common;

import com.google.code.kaptcha.Producer;
import com.ruan.Lagou.config.CaptchaConfig;
import com.ruan.Lagou.constant.CacheKey;
import com.ruan.Lagou.enums.BizCodeEnum;
import com.ruan.Lagou.enums.SendCodeEnum;
import com.ruan.Lagou.service.common.NotifyService;
import com.ruan.Lagou.util.CommonUtil;
import com.ruan.Lagou.util.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.statement.select.KSQLWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ruan
 * Date: 2021/12/11 17:54
 * @Description: 用户通知控制器
 */
@Slf4j
@Api(tags = "用户通知模块")
@RestController
@RequestMapping("api/notify")
public class NotifyController {

    @Autowired
    private Producer producer;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private NotifyService notifyService;

    @GetMapping("get_captcha")
    @ApiOperation("获取图形验证码")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response){
        String text = producer.createText();
        log.info("生成验证码：{}",text);
        //保存验证码
        redisTemplate.opsForValue().set(getCaptchaKey(request),text,5,TimeUnit.MINUTES);
        BufferedImage image = producer.createImage(text);
        //获得输出流输出验证码图片
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("验证码 生成异常");
        }
    }

    @ApiOperation("发送验证码")
    @GetMapping("send_code")
    public JsonData sendRegisterCode(@ApiParam("收信人") @RequestParam(value = "to") String to,
                                     @ApiParam("验证码") @RequestParam(value = "captcha") String captcha,
                                     HttpServletRequest request){
        //获取验证码的key
        String key = getCaptchaKey(request);
        //获取缓存中的验证码
        String cacheCaptcha = redisTemplate.opsForValue().get(key);
        if (cacheCaptcha != null && captcha != null && cacheCaptcha.equals(captcha)){
            redisTemplate.delete(key);
            JsonData jsonData = notifyService.sendCode(SendCodeEnum.USER_REGISTRATION,to);
            return jsonData;
        }else {
            return JsonData.buildResult(BizCodeEnum.CODE_ERROR);
        }

    }




    /**
     * 根据ip和浏览器指纹获取缓存的key
     * @param request
     * @return
     */
    public String getCaptchaKey(HttpServletRequest request){
        String ip = CommonUtil.getIpAddr(request);
        String userAgent = request.getHeader("User-Agent");
        String key = "user-service:captcha" + CommonUtil.MD5(ip + userAgent);
        return key;
    }
}
