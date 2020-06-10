package top.kwind.rlfz.course.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.course.pojo.Course;
import top.kwind.rlfz.course.pojo.CourseUser;
import top.kwind.rlfz.course.mapper.CourseUserMapper;
import top.kwind.rlfz.course.service.CourseUserService;
import top.kwind.rlfz.rbac.pojo.User;

import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class CourseUserServiceImpl implements CourseUserService{

    @Resource
    private CourseUserMapper courseUserMapper;


    @Override
    public List<Course> getCoursesByUserId(Integer id) {
        return courseUserMapper.selectCoursesByUser(id);
    }

    @Override
    public List<User> getUsersByCourseId(Integer id) {
        return courseUserMapper.selectUsersByCourse(id);
    }

    @Override
    public Boolean insertUserCourse(CourseUser courseUser) {
        return courseUserMapper.insertUserCourse(courseUser) > 0;
    }

    @Override
    public Boolean deleteUserCourse(CourseUser courseUser) {
        return courseUserMapper.deleteUserCourse(courseUser) > 0;
    }
}
