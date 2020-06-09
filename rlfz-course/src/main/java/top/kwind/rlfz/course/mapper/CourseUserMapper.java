package top.kwind.rlfz.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.course.pojo.Course;
import top.kwind.rlfz.course.pojo.CourseUser;
import top.kwind.rlfz.rbac.pojo.User;

import java.util.List;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Mapper
public interface CourseUserMapper {

    /**
     * 通过用户查其参加的课程
     * @param id
     * @return
     */
    List<Course> selectCoursesByUser(Integer id);

    /**
     * 通过课程查用户
     * @param id
     * @return
     */
    List<User> selectUsersByCourse(Integer id);

    /**
     * 给用户添加课程
     * @param courseUser
     * @return
     */
    int insertUserCourse(CourseUser courseUser);

    /**
     * 为用户删除课程
     * @param courseUser
     * @return
     */
    int deleteUserCourse(CourseUser courseUser);
}