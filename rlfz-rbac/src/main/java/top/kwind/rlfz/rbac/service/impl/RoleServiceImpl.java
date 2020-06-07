package top.kwind.rlfz.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import top.kwind.rlfz.common.tools.DateUtils;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.pojo.Role;

import java.util.List;

import top.kwind.rlfz.rbac.mapper.RoleMapper;
import top.kwind.rlfz.rbac.service.RoleService;

/**
 * @author xagu
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Boolean insertRole(Role role) {
        role.setCreateTime(DateUtils.getNowDate());
        return roleMapper.insertRole(role) > 0;
    }

    @Override
    public PageInfo<Role> selectByAll(PageDomain pageDomain, Role role) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<Role>(roleMapper.selectByAll(role));
    }

    @Override
    public Boolean updateById(Role role) {
        return roleMapper.updateById(role) > 0;
    }

    @Override
    public Boolean batchDelete(String[] split) {
        return roleMapper.batchDelete(split) > 0;
    }

}
