package top.kwind.rlfz.sign.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.common.tools.DateUtils;
import top.kwind.rlfz.common.tools.security.SecurityUtil;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.pojo.User;
import top.kwind.rlfz.sign.mapper.UserSignMapper;
import top.kwind.rlfz.sign.pojo.UserCourseSign;
import top.kwind.rlfz.sign.pojo.UserSign;
import top.kwind.rlfz.sign.service.UserSignService;
@Service("userSignService")
public class UserSignServiceImpl implements UserSignService{

    @Resource
    private UserSignMapper userSignMapper;

    @Override
    public PageInfo<UserCourseSign> selectByUser(PageDomain pageDomain, String courseId) {
        User loginUser = (User) SecurityUtil.getLoginUser();
        if (loginUser != null) {
            int id = loginUser.getUserId();
            PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
            return new PageInfo<>(userSignMapper.selectByUser(courseId, id));
        }else {
            return null;
        }

    }

    @Override
    public Boolean insertUserSign(UserSign userSign) {
        userSign.setSignTime(DateUtils.getNowDate());
        return userSignMapper.insertUserSign(userSign)>0;
    }

    @Override
    public boolean batchDelete(String[] ids) {
        return userSignMapper.batchDelete(ids)>0;
    }
}
