package top.kwind.rlfz.rbac.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.pojo.Role;
import top.kwind.rlfz.rbac.service.RoleService;

import javax.annotation.Resource;

/**
 * @author xagu
 * Created on 2020/6/7
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@RestController
@RequestMapping("api/role")
public class RoleController extends BaseController {

    @Resource
    RoleService roleService;

    /**
     * 插入新角色
     *
     * @param role
     * @return
     */
    @PostMapping
    public ResuBean insertUser(Role role) {
        return decide(roleService.insertRole(role),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 根据条件查询角色
     *
     * @param pageDomain
     * @param role       参数可选，参数为空则查询所有
     * @return
     */
    @GetMapping
    public ResuTable select(PageDomain pageDomain, Role role) {
        PageInfo<Role> userPageInfo = roleService.selectByAll(pageDomain, role);
        return pageTable(userPageInfo.getList(), userPageInfo.getTotal());
    }

    /**
     * 更新角色数据
     * @param role
     * @return
     */
    @PutMapping
    public ResuBean update(Role role) {
        return decide(roleService.updateById(role),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除角色
     * @param ids 角色的id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids) {
        return decide(roleService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

}
