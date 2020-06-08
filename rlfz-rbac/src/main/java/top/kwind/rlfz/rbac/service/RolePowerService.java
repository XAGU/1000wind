package top.kwind.rlfz.rbac.service;

import java.util.List;
import top.kwind.rlfz.rbac.pojo.RolePower;
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
}
