package top.kwind.rlfz.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.common.tools.security.SecurityUtil;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
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
    public PageInfo<User> getUsersByCourseId(PageDomain pageDomain,Integer id, User user) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        return new PageInfo<>(courseUserMapper.selectUsersByCourse(id,user));
    }

    @Override
    public Boolean insertUserCourse(CourseUser courseUser) {
        return courseUserMapper.insertUserCourse(courseUser) > 0;
    }

    @Override
    public Boolean deleteUserCourse(Integer cId,Integer sId) {
        return courseUserMapper.deleteUserCourse(cId,sId) > 0;
    }

    @Override
    public List<Course> getCoursesByNowUserId() {
        User loginUser = (User) SecurityUtil.getLoginUser();
        if (loginUser != null) {
            int id = loginUser.getUserId();
            return courseUserMapper.selectCoursesByUser(id);
        }else {
            return null;
        }
    }
}
