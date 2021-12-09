package com.ruan.Lagou.vo.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ruan
 * Date: 2021/12/9 21:39
 * @Description: 基础实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseEntityVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    private Long id;

    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonProperty("update_time")
    private Date updateTime;
}
