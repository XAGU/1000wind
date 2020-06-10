package top.kwind.rlfz.rbac.controller;

import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.rbac.service.RolePowerService;

import javax.annotation.Resource;

/**
 * @author xagu
 * Created on 2020/6/7
 * Email:xagu_qc@foxmail.com
 * Describe: 角色的权限的相关操作
 */
@RestController
@RequestMapping("api/rolePower")
public class RolePowerController extends BaseController {

    @Resource
    private RolePowerService rolePowerService;


    /**
     * 修改角色所拥有的权限
     *
     * @param roleId
     * @param powerIds
     * @return
     */
    @PutMapping
    public ResuBean updatePowerOfRole(Integer roleId, String powerIds) {
        return decide(rolePowerService.updatePowerOfRole(roleId, powerIds.split(",")),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * Describe: 获取角色权限
     * Param RoleId
     * Return ResuTree
     */
    @GetMapping("/{roleId}")
    public ResuTable getRolePower(@PathVariable("roleId") Integer roleId) {
        return dataTable(rolePowerService.getPowerOfRole(roleId));
    }
}
