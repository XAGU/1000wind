package top.kwind.rlfz.rbac.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.rbac.pojo.UserRole;

@Mapper
public interface UserRoleMapper {
    /**
     * 插入
     * @param userRole
     * @return
     */
    int insert(UserRole userRole);


    /**
     * 删除用户的角色信息
     * @param userId
     * @return
     */
    boolean deleteByUserId(Integer userId);
}