package top.kwind.rlfz.sign.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.sign.pojo.Sign;

public interface SignService{

    /**
     * 根据条件查询所有
     * @param pageDomain
     * @param sign
     * @return
     */
    PageInfo<Sign> selectByAll(PageDomain pageDomain,Sign sign);

    /**
     * 添加签到信息
     * @param sign
     * @return
     */
    Boolean insertSign(Sign sign);


    /**
     * 删除签到信息
     * @param ids
     * @return
     */
    Boolean deleteById(String[] ids);
}
