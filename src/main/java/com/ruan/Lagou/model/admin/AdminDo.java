package com.ruan.Lagou.model.admin;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruan.Lagou.model.common.BaseEntityDo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @Author: ruan
 * Date: 2021/12/9 21:49
 * @Description:
 */
@Data
@EntityScan
@TableName("admin")
@EqualsAndHashCode(callSuper = false)
public class AdminDo extends BaseEntityDo {
    private static final long serialVersionUID = 1L;

    /**
     * 男
     */
    private static final int USER_SEX_MAN = 1;

    /**
     * 女
     */
    private static final int USER_SEX_WOMAN = 2;

    /**
     * 未知
     */
    private static final int USER_SEX_UNKONW = 0;

    /**
     * 默认用户头像
     */
    private static final String DEFAULT_HEAD_IMAGE = "common/default_img.jpg";

    /**
     * 用户名
     */
    @JsonProperty("admin_name")
    private String adminName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户头像
     */
    @JsonProperty("head_pic")
    private String headPic = DEFAULT_HEAD_IMAGE;

    /**
     * 用户性别
     */
    private int sex = USER_SEX_UNKONW;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 用户邮箱
     */
    private String email;
}
