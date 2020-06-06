package top.kwind.rlfz.rbac.mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PutMapping;
import top.kwind.rlfz.rbac.pojo.User;

/**
 * User Mapper层
 * @author xagu
 */
@Mapper
public interface UserMapper {

    /**
     * 根据条件查询所有
     *
     * @param user
     * @return
     */
    List<User> selectByAll(User user);


    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUser(User user);


    /**
     * 根据条件修改用户
     * @param user
     * @return
     */
    int updateById(@Param("user") User user);


    int batchDelete(String[] ids);
}