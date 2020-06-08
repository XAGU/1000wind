package top.kwind.rlfz.rbac.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.kwind.rlfz.rbac.pojo.Power;

import java.util.List;

@Mapper
public interface PowerMapper {


    /**
     * 查询所有,参数可选
     *
     * @param power
     * @return
     */
    List<Power> selectByAll(Power power);

    /**
     * 插入权限
     *
     * @param power
     * @return
     */
    int insert(Power power);



    /**
     * 更新权限，传进来什么就更新什么
     *
     * @param power
     * @return
     */
    int updateById(Power power);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int batchDelete(String[] ids);
}