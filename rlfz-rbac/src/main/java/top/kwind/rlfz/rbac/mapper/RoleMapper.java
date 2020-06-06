package top.kwind.rlfz.rbac.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.rbac.pojo.Role;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);
}