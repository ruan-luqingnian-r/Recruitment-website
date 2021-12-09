package com.ruan.Lagou.controller.admin;

import com.ruan.Lagou.service.AdminService;
import com.ruan.Lagou.util.JsonData;
import com.ruan.Lagou.vo.admin.AdminVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/12/9 21:29
 * @Description:
 */
@Api(tags = "管理员模块")
@RestController
@RequestMapping("admin/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @ApiOperation("查看管理员列表")
    @GetMapping("my_info_list")
    public JsonData myInfoList(){
        List<AdminVo> voList = adminService.myInfoList();
        return JsonData.buildSuccess(voList);
    }
}
