package com.ruan.Lagou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruan.Lagou.mapper.AdminMapper;
import com.ruan.Lagou.model.admin.AdminDo;
import com.ruan.Lagou.request.AdminAdd;
import com.ruan.Lagou.service.AdminService;
import com.ruan.Lagou.util.JsonData;
import com.ruan.Lagou.vo.admin.AdminVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    /**
     * 根据id查询管理员详细信息
     * @param id 管理员id
     * @return 管理员详细信息
     */
    @Override
    public AdminVo findInfoById(Long id) {
        AdminDo adminDo = adminMapper.selectById(id);
        AdminVo adminVo = new AdminVo();
        if (adminDo != null){
            BeanUtils.copyProperties(adminDo,adminVo);
        }
        return adminVo;
    }

    /**
     * 添加管理员信息
     * @param admin 管理员信息
     * @return 数据修改行数
     */
    @Override
    public int addAdminInfo(AdminAdd admin) {
        AdminDo adminDo = new AdminDo();
        BeanUtils.copyProperties(admin,adminDo);
        adminDo.setCreateTime(new Date());
        adminDo.setUpdateTime(new Date());
        int insert = adminMapper.insert(adminDo);
        log.info("新增管理员:{}",adminDo.getAdminName());
        return insert;
    }

    /**
     * 根据id修改管理员信息
     * @param id 待修改的管理员id
     * @param newAdminInfo 新信息
     * @return 数据修改行数
     */
    @Override
    public int updateAdminInfo(Long id, AdminAdd newAdminInfo) {
        AdminVo oldAdmin = findInfoById(id);
        BeanUtils.copyProperties(newAdminInfo,oldAdmin,"id","createTime","updateTime");
        AdminDo adminDo = new AdminDo();
        BeanUtils.copyProperties(oldAdmin,adminDo);
        adminDo.setUpdateTime(new Date());
        int i = adminMapper.updateById(adminDo);
        return i;
    }

    /**
     * 根据id删除管理员信息
     * @param id 待删除数据的id
     * @return 数据修改行数
     */
    @Override
    public int delAdminById(Long id) {
        return adminMapper.deleteById(id);
    }
}
