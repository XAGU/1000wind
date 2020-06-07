package top.kwind.rlfz.course.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.pojo.Course;
import top.kwind.rlfz.course.service.CourseService;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/7 12:26
 */
@RestController
@RequestMapping("api/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Course course){
        PageInfo<Course> coursePageInfo = courseService.selectByAll(pageDomain,course);
        return pageTable(coursePageInfo.getList(),coursePageInfo.getTotal());
    }
}
