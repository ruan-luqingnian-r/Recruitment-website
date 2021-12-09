package com.ruan.Lagou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruan.Lagou.model.admin.AdminDo;
import org.springframework.stereotype.Repository;

/**
 * @Author: ruan
 * Date: 2021/12/9 22:08
 * @Description: 管理员mapper接口
 */
@Repository
public interface AdminMapper extends BaseMapper<AdminDo> {
}
