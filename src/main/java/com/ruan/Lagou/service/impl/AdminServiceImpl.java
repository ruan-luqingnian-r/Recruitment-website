package com.ruan.Lagou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruan.Lagou.mapper.AdminMapper;
import com.ruan.Lagou.model.admin.AdminDo;
import com.ruan.Lagou.service.AdminService;
import com.ruan.Lagou.util.JsonData;
import com.ruan.Lagou.vo.admin.AdminVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: ruan
 * Date: 2021/12/9 22:15
 * @Description:
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDo> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 获取全部管理员信息
     * @return 管理员信息列表
     */
    @Override
    public List<AdminVo> myInfoList() {
        //查询全部管理员信息
        List<AdminDo> doList = adminMapper.selectList(new QueryWrapper<AdminDo>());
        //信息包装Do转Vo
        List<AdminVo> voList = doList.stream().map(adminDo -> {
            AdminVo adminVo = new AdminVo();
            BeanUtils.copyProperties(adminDo,adminVo);
            return adminVo;
        }).collect(Collectors.toList());
        return voList;
    }
}
