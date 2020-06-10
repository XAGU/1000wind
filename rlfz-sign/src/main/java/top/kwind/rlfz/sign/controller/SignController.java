package top.kwind.rlfz.sign.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.sign.pojo.Sign;
import top.kwind.rlfz.sign.service.SignService;

import javax.annotation.Resource;

import static top.kwind.rlfz.common.web.base.BaseController.decide;
import static top.kwind.rlfz.common.web.base.BaseController.pageTable;

@RestController
@RequestMapping("api/sign")
public class SignController {

    @Resource
    private SignService signService;

    /**
     * 根据条件查询所有
     * @param pageDomain
     * @param sign
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Sign sign){
        PageInfo<Sign> signPageInfo = signService.selectByAll(pageDomain,sign);
        return pageTable(signPageInfo.getList(),signPageInfo.getTotal());
    }

    /**
     * 添加签到信息
     * @param sign
     * @return
     */
    @PostMapping
    public ResuBean insertSign(Sign sign){
        return decide(signService.insertSign(sign),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }


    @DeleteMapping("{ids}")
    public ResuBean delete(@PathVariable String ids){
        System.out.println(ids);
        return decide(signService.deleteById(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

}
