package top.kwind.rlfz.rbac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import top.kwind.rlfz.common.tools.DateUtils;
import top.kwind.rlfz.common.tools.security.SecurityUtil;
import top.kwind.rlfz.common.web.domain.ResuMenu;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.mapper.UserRoleMapper;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.pojo.User;
import top.kwind.rlfz.rbac.mapper.UserMapper;
import top.kwind.rlfz.rbac.pojo.UserRole;
import top.kwind.rlfz.rbac.service.UserService;
import top.kwind.rlfz.rbac.vo.UserWithPower;

/**
 * @author xagu
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;


    @Override
    public PageInfo<User> selectByAll(PageDomain pageDomain, User user) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<User> users = userMapper.selectByAll(user);
        return new PageInfo<>(users);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean insertUser(User user) {
        //设置当前时间
        user.setRegTime(DateUtils.getNowDate());
        //1、插入用户
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userMapper.insertUser(user);
        //2、给用户赋予权限
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getUserId());
        userRole.setRoleId(user.getRoleId());
        return userRoleMapper.insert(userRole) > 0;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean updateById(User user) {
        Integer roleId = user.getRoleId();
        if (roleId != null) {
            //删除以前的角色
            userRoleMapper.deleteByUserId(user.getUserId());
            //插入现在的角色
            UserRole userRole = new UserRole(user.getUserId(), user.getRoleId());
            userRoleMapper.insert(userRole);
        }
        String password = user.getPassword();
        if (!StringUtils.isEmpty(password)) {
            user.setPassword(new BCryptPasswordEncoder().encode(password));
        }
        return userMapper.updateById(user) > 0;
    }

    @Override
    public Boolean batchDelete(String[] ids) {
        return userMapper.batchDelete(ids) > 0;
    }

    @Override
    public List<ResuMenu> getLoginUserPowers() {
        UserWithPower loginUser = (UserWithPower) SecurityUtil.getLoginUser();
        if (loginUser == null || loginUser.getPowers() == null) {
            return null;
        }
        List<Power> powers = loginUser.getPowers();
        List<ResuMenu> resuMenus = new ArrayList<>();
        for (Power power : powers) {
            ResuMenu resuMenu = new ResuMenu();
            resuMenu.setId(power.getPowerId());
            resuMenu.setTitle(power.getPowerName());
            resuMenu.setHref(power.getPowerUrl());
            resuMenu.setIcon(power.getIcon());
            resuMenu.setType(power.getPowerType());
            resuMenu.setParentId(power.getParentId());
            resuMenus.add(resuMenu);
        }
        return resuMenus;
    }
}

