package top.kwind.rlfz.sign.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.sign.pojo.UserCourseSign;
import top.kwind.rlfz.sign.pojo.UserSign;

import java.util.List;

@Mapper
public interface UserSignMapper {

    /**
     * 通过用户ID查询该用户的所有签到信息
     */
    List<UserCourseSign> selectByUser(String courseId,Integer userId);


    /**
     * 用户签到
     * @param userSign
     * @return
     */
    int insertUserSign(UserSign userSign);

    /**
     * 通过id批量删除
      * @param ids
     * @return
     */
    int batchDelete(String[] ids);
}