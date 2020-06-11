package top.kwind.rlfz.sign.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.common.tools.DateUtils;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.sign.mapper.SignMapper;
import top.kwind.rlfz.sign.pojo.Sign;
import top.kwind.rlfz.sign.service.SignService;
@Service("signService")
public class SignServiceImpl implements SignService{

    @Resource
    private SignMapper signMapper;

    @Override
    public PageInfo<Sign> selectByAll(PageDomain pageDomain, Sign sign) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(signMapper.selectByAll(sign));
    }

    @Override
    public Boolean insertSign(Sign sign) {
        sign.setCreateTime(DateUtils.getNowDate());
        return signMapper.insertSign(sign)>0;
    }


    @Override
    public Boolean deleteById(String[] ids) {
        return signMapper.deleteById(ids)>0;
    }
}
