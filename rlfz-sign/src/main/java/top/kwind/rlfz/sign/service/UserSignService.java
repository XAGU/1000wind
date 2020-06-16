package top.kwind.rlfz.sign.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.sign.pojo.UserCourseSign;
import top.kwind.rlfz.sign.pojo.UserSign;

public interface UserSignService{

    /**
     * 查询登录用户的签到信息
     * @param pageDomain
     * @return
     */
    PageInfo<UserCourseSign> selectByUser(PageDomain pageDomain, String courseId);

    /**
     * 用户签到
     * @param userSign
     * @return
     */
    Boolean insertUserSign(UserSign userSign);


    boolean batchDelete(String[] ids);
}
