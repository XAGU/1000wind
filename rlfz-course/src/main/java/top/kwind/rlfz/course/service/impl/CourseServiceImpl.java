package top.kwind.rlfz.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

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
}
