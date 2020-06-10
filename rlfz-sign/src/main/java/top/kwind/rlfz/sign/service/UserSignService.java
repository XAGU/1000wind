package top.kwind.rlfz.sign.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.sign.pojo.UserSign;

public interface UserSignService{

    /**
     * 通过用户查询用户的签到信息
     * @param pageDomain
     * @param userId
     * @return
     */
    PageInfo<UserSign> selectByUser(PageDomain pageDomain, String userId);

    /**
     * 用户签到
     * @param userSign
     * @return
     */
    Boolean insertUserSign(UserSign userSign);
}
