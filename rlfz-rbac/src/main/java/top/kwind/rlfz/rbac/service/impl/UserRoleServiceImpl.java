package top.kwind.rlfz.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import top.kwind.rlfz.rbac.mapper.UserRoleMapper;
import top.kwind.rlfz.rbac.pojo.UserRole;
import top.kwind.rlfz.rbac.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;


}
