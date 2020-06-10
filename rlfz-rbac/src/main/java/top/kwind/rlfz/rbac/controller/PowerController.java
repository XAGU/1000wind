package top.kwind.rlfz.rbac.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.pojo.RolePower;
import top.kwind.rlfz.rbac.service.PowerService;

import javax.annotation.Resource;

/**
 * @author xagu
 * Created on 2020/6/8
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@RestController
@RequestMapping("api/power")
public class PowerController extends BaseController {

    @Resource
    private PowerService powerService;


    /**
     * 分页查询所有，参数条件可选
     *
     * @param pageDomain
     * @param power
     */
    @GetMapping
    public ResuTable select(PageDomain pageDomain, Power power) {
        PageInfo<Power> powerPageInfo = powerService.selectByAll(pageDomain, power);
        return pageTable(powerPageInfo.getList(), powerPageInfo.getTotal());
    }

    /**
     * 插入新权限
     *
     * @param power
     * @return
     */
    @PostMapping
    public ResuBean insertUser(Power power) {
        return decide(powerService.insertPower(power),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }


    /**
     * 更新权限信息
     *
     * @param power
     * @return
     */
    @PutMapping
    public ResuBean update(Power power) {
        return decide(powerService.updateById(power),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除权限
     *
     * @param ids 权限的id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids) {
        return decide(powerService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }
}
