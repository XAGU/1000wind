package top.kwind.rlfz.rbac.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.rbac.pojo.RolePower;

@Mapper
public interface RolePowerMapper {

    /**
     * 根据角色id删除角色
     * @param roleId
     * @return
     */
    int deletePowerByRoleId(@Param("roleId")Integer roleId);


    /**
     * 给角色添加权限
     * @param roleId
     * @param split
     * @return
     */
    int addPowerToRole(@Param("roleId") Integer roleId,@Param("powerIds") String[] split);



}