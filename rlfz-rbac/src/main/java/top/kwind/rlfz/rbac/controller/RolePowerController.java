package top.kwind.rlfz.rbac.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
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
     * @param roleId
     * @param powerIds
     * @return
     */
    @PutMapping
    public ResuBean updatePowerOfRole(String roleId, String powerIds) {
        return decide(rolePowerService.updatePowerOfRole(roleId, powerIds.split(",")),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }
}
