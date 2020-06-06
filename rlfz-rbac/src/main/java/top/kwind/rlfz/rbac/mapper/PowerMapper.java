package top.kwind.rlfz.rbac.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.rbac.pojo.Power;

@Mapper
public interface PowerMapper {
    /**
     * 删除权限根据权限ID
     * @param powerId
     * @return
     */
    int deleteById(Integer powerId);

    /**
     * 插入权限
     * @param power
     * @return
     */
    int insert(Power power);


    /**
     * 查询所有
     * @param enable
     * @return
     */
    List<Power> selectAll(@Param("enable")Byte enable);



    /**
     * 根据id查询权限
     * @param powerId
     * @return
     */
    Power selectById(Integer powerId);

    /**
     * 更新权限，传进来什么就更新什么
     * @param power
     * @return
     */
    int updateByIdSelective(Power power);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(String[] ids);
}