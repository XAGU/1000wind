package top.kwind.rlfz.rbac.service;

import top.kwind.rlfz.rbac.pojo.Role;
import java.util.List;
public interface RoleService{


    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

}
