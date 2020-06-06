package top.kwind.rlfz.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import top.kwind.rlfz.rbac.pojo.Role;
import java.util.List;
import top.kwind.rlfz.rbac.mapper.RoleMapper;
import top.kwind.rlfz.rbac.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Role> list) {
        return roleMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Role> list) {
        return roleMapper.updateBatchSelective(list);
    }

}
