package top.kwind.rlfz.sign.controller;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.sign.pojo.Sign;
import top.kwind.rlfz.sign.pojo.UserCourseSign;
import top.kwind.rlfz.sign.pojo.UserSign;
import top.kwind.rlfz.sign.service.UserSignService;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/userSign")
public class UserSignController extends BaseController {

    @Resource
    private UserSignService userSignService;


    /**
     * 查询登录用户签到信息
     */
    @GetMapping
    public ResuTable selectByUser(PageDomain pageDomain,String courseId){
        PageInfo<UserCourseSign> userPageInfo = userSignService.selectByUser(pageDomain,courseId);
        return pageTable(userPageInfo.getList(),userPageInfo.getTotal());
    }

    /**
     * 用户签到
     * @param userSign
     * @return
     */
    @PostMapping
    public ResuBean insertUserSign(UserSign userSign){
        return decide(userSignService.insertUserSign(userSign),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 批量删除
     *
     * @param ids id，逗号分隔
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids){
        return decide(userSignService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

}
