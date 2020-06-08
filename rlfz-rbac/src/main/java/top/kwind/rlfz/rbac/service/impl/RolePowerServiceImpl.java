package top.kwind.rlfz.rbac.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import top.kwind.rlfz.rbac.pojo.RolePower;
import top.kwind.rlfz.rbac.mapper.RolePowerMapper;
import top.kwind.rlfz.rbac.service.RolePowerService;

@Service("rolePowerService")
public class RolePowerServiceImpl implements RolePowerService {

    @Resource
    private RolePowerMapper rolePowerMapper;


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Boolean updatePowerOfRole(Integer roleId, String[] split) {
        //清空用户之前的权限
        rolePowerMapper.deletePowerByRoleId(roleId);
        //当传进来的权限id为空，就说明把某个角色的权限全部删除了
        if (split.length == 0) {
            //直接返回，不用插入了
            return true;
        }
        //将新权限加进去
        return rolePowerMapper.addPowerToRole(roleId, split) > 0;
    }
}
