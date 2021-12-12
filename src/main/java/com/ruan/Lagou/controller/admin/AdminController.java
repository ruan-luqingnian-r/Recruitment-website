package com.ruan.Lagou.controller.admin;

import com.ruan.Lagou.request.AdminAdd;
import com.ruan.Lagou.service.admin.AdminService;
import com.ruan.Lagou.util.JsonData;
import com.ruan.Lagou.vo.admin.AdminVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ruan
 * Date: 2021/12/9 21:29
 * @Description: 管理员控制器
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

    @ApiOperation("根据id查看管理员信息")
    @GetMapping("find_info_by_id/{admin_id}")
    public JsonData findInfoById(@ApiParam(value = "管理员id", required = true) @PathVariable("admin_id") Long id){
        AdminVo infoById = adminService.findInfoById(id);
        return infoById.getId() == null ? JsonData.buildError("管理员不存在") : JsonData.buildSuccess(infoById);
    }

    @ApiOperation("新增管理员信息")
    @PostMapping("add_admin_info")
    public JsonData addAdminInfo(@ApiParam(value = "管理员信息", required = true) @RequestBody AdminAdd adminAdd){
        int i = adminService.addAdminInfo(adminAdd);
        return i == 1 ? JsonData.buildSuccess("添加成功") : JsonData.buildError("添加失败");
    }

    @ApiOperation("修改管理员信息")
    @PutMapping("update_by_id/{admin_id}")
    public JsonData updateById(@ApiParam(value = "管理员id") @PathVariable("admin_id") Long id,@ApiParam("新数据") @RequestBody AdminAdd adminAdd){
        int i = adminService.updateAdminInfo(id, adminAdd);
        return i == 1 ? JsonData.buildSuccess("更新成功") : JsonData.buildError("更新失败");
    }

    @ApiOperation("根据id删除管理员信息")
    @DeleteMapping("delet_Info_by_id/{admin_id}")
    public JsonData delInfoById(@ApiParam(value = "管理员id", required = true) @PathVariable("admin_id") Long id){
        int i = adminService.delAdminById(id);
        return i == 1 ? JsonData.buildSuccess("删除成功") : JsonData.buildError("删除失败");
    }

}
