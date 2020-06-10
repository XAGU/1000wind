package top.kwind.rlfz.rbac.service;

import java.util.List;

import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.pojo.RolePower;
import top.kwind.rlfz.rbac.vo.PowerOfRole;

/**
 * @author xagu
 */
public interface RolePowerService{


    /**
     * 修改角色拥有的权限
     * @param roleId
     * @param split
     * @return
     */
    Boolean updatePowerOfRole(Integer roleId, String[] split);

    /**
     * Describe: 获取角色权限
     * @param roleId
     * @return
     */
    List<PowerOfRole> getPowerOfRole(Integer roleId);
}
