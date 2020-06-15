package top.kwind.rlfz.course.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
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
     * @param user
     * @return
     */
    PageInfo<User> getUsersByCourseId(PageDomain pageDomain,Integer id, User user);

    /**
     * 为用户添加课程
     * @param courseUser
     * @return
     */
    Boolean insertUserCourse(CourseUser courseUser);

    /**
     * 为用户删除课程
     * @param cId,sId
     * @return
     */
    Boolean deleteUserCourse(Integer cId,Integer sId);

    /**
     * 查询当前登录的学生的所有课程
     * @return
     */
    List<Course> getCoursesByNowUserId();
}
