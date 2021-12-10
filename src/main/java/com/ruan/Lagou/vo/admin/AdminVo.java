package com.ruan.Lagou.vo.admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruan.Lagou.vo.common.BaseEntityVo;
import lombok.Data;

/**
 * @Author: ruan
 * Date: 2021/12/9 22:00
 * @Description: 管理员包装类
 */
@Data
public class AdminVo extends BaseEntityVo {
    private static final long serialVersionUID = 1L;


    /**
     * 未知
     */
    private static final int USER_SEX_UNKONW = 0;



    /**
     * 用户名
     */
    @JsonProperty("admin_name")
    private String adminName;

    /**
     * 用户头像
     */
    @JsonProperty("head_pic")
    private String headPic;

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
