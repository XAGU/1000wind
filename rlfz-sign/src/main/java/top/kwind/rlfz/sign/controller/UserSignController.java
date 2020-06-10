package top.kwind.rlfz.sign.controller;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.sign.pojo.UserSign;
import top.kwind.rlfz.sign.service.UserSignService;

import javax.annotation.Resource;

import static top.kwind.rlfz.common.web.base.BaseController.decide;
import static top.kwind.rlfz.common.web.base.BaseController.pageTable;

@RestController
@RequestMapping("api/userSign")
public class UserSignController {

    @Resource
    private UserSignService userSignService;


    /**
     * 根据用户查询签到信息
     */
    @GetMapping
    public ResuTable selectByUser(PageDomain pageDomain, @Param("userId") String userId){
        System.out.println(userId);
        PageInfo<UserSign> userPageInfo = userSignService.selectByUser(pageDomain,userId);
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

}
