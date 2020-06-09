package top.kwind.rlfz.course.service;

import top.kwind.rlfz.course.pojo.Course;
import top.kwind.rlfz.course.pojo.CourseUser;
import top.kwind.rlfz.rbac.pojo.User;

import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseUserService{

    /**
     * 查询某个用户所拥有的课程
     * @param id
     * @return
     */
    List<Course> getCoursesByUserId(Integer id);

    /**
     * 查询某个课程下的所有用户
     * @param id
     * @return
     */
    List<User> getUsersByCourseId(Integer id);

    /**
     * 为用户添加课程
     * @param courseUser
     * @return
     */
    Boolean insertUserCourse(CourseUser courseUser);

    /**
     * 为用户删除课程
     * @param courseUser
     * @return
     */
    Boolean deleteUserCourse(CourseUser courseUser);
}
