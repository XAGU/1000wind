package top.kwind.rlfz.rbac.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.pojo.User;
import top.kwind.rlfz.rbac.service.UserService;

import javax.annotation.Resource;

/**
 * @author xagu
 * Created on 2020/6/6
 * Email:xagu_qc@foxmail.com
 * Describe: 用户操作相关
 */
@RestController
@RequestMapping("api/user")
@Validated
public class UserController extends BaseController {


    @Resource
    UserService userService;


    /**
     * 插入新用户
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResuBean insertUser(User user) {
        return decide(userService.insertUser(user),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 根据条件查询所有
     *
     * @param pageDomain
     * @param user       参数可选，参数为空则查询所有
     * @return
     */
    @GetMapping
    public ResuTable select(PageDomain pageDomain, User user) {
        PageInfo<User> userPageInfo = userService.selectByAll(pageDomain, user);
        return pageTable(userPageInfo.getList(), userPageInfo.getTotal());
    }

    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    @PutMapping
    public ResuBean update(User user) {
        return decide(userService.updateById(user),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除用户
     *
     * @param ids 用户的id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids) {
        return decide(userService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

    /**
     * 获取当前登录用户的所有菜单
     *
     * @return
     */
    @GetMapping("menus")
    public ResuTable getLoginUserPowers() {
        return dataTable(userService.getLoginUserPowers());
    }

    /**
     * 获取当前登录用户个人信息
     *
     * @return
     */
    @GetMapping("myself")
    public ResuBean getLoginUser() {
        User loginUser = userService.getLoginUser();
        return decide(loginUser != null,
                MessageConstants.SELECT_SUCCESS,
                MessageConstants.SELECT_FAILURE,
                loginUser);
    }

}
