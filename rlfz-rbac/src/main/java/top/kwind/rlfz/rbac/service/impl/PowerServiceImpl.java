package top.kwind.rlfz.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.mapper.PowerMapper;
import top.kwind.rlfz.rbac.service.PowerService;

@Service("powerService")
public class PowerServiceImpl implements PowerService {

    @Resource
    private PowerMapper powerMapper;

    @Override
    public PageInfo<Power> selectByAll(PageDomain pageDomain, Power power) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<>(powerMapper.selectByAll(power));
    }

    @Override
    public Boolean insertPower(Power power) {
        return powerMapper.insert(power) > 0;
    }

    @Override
    public Boolean updateById(Power power) {
        return powerMapper.updateById(power) > 0;
    }

    @Override
    public Boolean batchDelete(String[] split) {
        return powerMapper.batchDelete(split) > 0;
    }
}

