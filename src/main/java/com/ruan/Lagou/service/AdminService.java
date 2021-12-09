package com.ruan.Lagou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruan.Lagou.model.admin.AdminDo;
import com.ruan.Lagou.util.JsonData;
import com.ruan.Lagou.vo.admin.AdminVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/12/9 22:10
 * @Description: 管理员信息服务
 */

public interface AdminService extends IService<AdminDo> {

    /**
     * 获取全部管理员信息
     * @return 管理员信息列表
     */
    List<AdminVo> myInfoList ();
}
