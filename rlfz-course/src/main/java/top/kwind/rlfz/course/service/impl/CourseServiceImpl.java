package top.kwind.rlfz.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;
import top.kwind.rlfz.common.tools.DateUtils;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.mapper.CourseMapper;
import top.kwind.rlfz.course.pojo.Course;
import top.kwind.rlfz.course.service.CourseService;
/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service("courseService")
public class CourseServiceImpl implements CourseService{

    @Resource
    private CourseMapper courseMapper;


    @Override
    public PageInfo<Course> selectByAll(PageDomain pageDomain, Course course) {

        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<Course>(courseMapper.selectByAll(course));
    }

    @Override
    public Boolean insertCourse(Course course) {
        //设置创建时间为当前时间
        course.setCreateTime(DateUtils.getNowDate());
        //判断是否设置了封面，没设置给默认路径值
        if(course.getCourseCover() == null && course.getCourseCover().equals("")){
            course.setCourseCover("https://unsplash.it/1000/450?image=116");
        }
        //设置点击量为0
        course.setCourseClick(0);
        //插入操作
        return courseMapper.insertCourse(course) > 0;

    }

    @Override
    public Boolean updateCourse(Course course) {
        return courseMapper.updateCourse(course) > 0;
    }

    @Override
    public Boolean batchDelete(String[] ids) {
        return courseMapper.batchDelete(ids) > 0;
    }

    @Override
    public Boolean updateCourseClick(Course course) {
        return courseMapper.updateCourseClick(course) > 0;
    }

}
