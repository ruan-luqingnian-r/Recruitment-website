package com.ruan.Lagou.service.admin;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruan.Lagou.model.admin.AdminDo;
import com.ruan.Lagou.request.AdminAdd;
import com.ruan.Lagou.vo.admin.AdminVo;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据id查询管理员详细信息
     * @param id 管理员id
     * @return 管理员详细信息
     */
    AdminVo findInfoById(Long id);

    /**
     * 添加管理员信息
     * @param admin 管理员信息
     * @return 数据修改行数
     */
    int addAdminInfo(AdminAdd admin);


    /**
     * 根据id修改管理员信息
     * @param id 待修改的管理员id
     * @param newAdminInfo 新信息
     * @return 数据修改行数
     */
    int updateAdminInfo(@Param("id") Long id,@Param("newAdminInfo") AdminAdd newAdminInfo);

    /**
     * 根据id删除管理员信息
     * @param id 待删除数据的id
     * @return 数据修改行数
     */
    int delAdminById(Long id);
}
