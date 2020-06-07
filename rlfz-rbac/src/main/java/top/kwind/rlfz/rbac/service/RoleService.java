package top.kwind.rlfz.rbac.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.rbac.pojo.Role;
import top.kwind.rlfz.rbac.pojo.User;

import java.util.List;
public interface RoleService{


    /**
     * 插入新角色
     * @param role
     * @return
     */
    Boolean insertRole(Role role);

    /**
     * 分页按条件查询角色
     * @param pageDomain
     * @param role
     * @return
     */
    PageInfo<Role> selectByAll(PageDomain pageDomain, Role role);

    /**
     * 修改权限信息
     * @param role
     * @return
     */
    Boolean updateById(Role role);

    /**
     * 批量删除角色信息
     * @param split
     * @return
     */
    Boolean batchDelete(String[] split);
}
