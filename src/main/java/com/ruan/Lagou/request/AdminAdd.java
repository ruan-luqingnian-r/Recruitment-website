package com.ruan.Lagou.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: ruan
 * Date: 2021/12/10 10:02
 * @Description: 添加管理员信息对象
 */
@Data
@ApiModel(value = "管理员对象",description = "新曾管理员信息")
public class AdminAdd {
    /**
     * 默认用户头像
     */
    private static final String DEFAULT_HEAD_IMAGE = "common/default_img.jpg";

    /**
     * 用户名
     */
    @JsonProperty("admin_name")
    @ApiModelProperty(value = "管理员姓名", example = "这是一个管理员")
    private String adminName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "管理员密码", example = "123456")
    private String password;

    /**
     * 用户头像
     */
    @JsonProperty("head_pic")
    @ApiModelProperty(value = "管理员头像",example = "common/default_img.jpg")
    private String headPic = DEFAULT_HEAD_IMAGE;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "管理员性别 1：男 2：女 0：未知",example = "0")
    private int sex = 0;

    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "管理员手机号",example = "15991875018")
    private String mobile;

    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "管理员邮箱",example = "15991875018@163.com")
    private String email;

}
