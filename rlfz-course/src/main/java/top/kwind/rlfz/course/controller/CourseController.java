package top.kwind.rlfz.course.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.pojo.Course;
import top.kwind.rlfz.course.service.CourseService;

import java.util.List;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/7 12:26
 */
@RestController
@RequestMapping("api/course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    /**
     * 根据条件查询课程
     * @param pageDomain
     * @param course
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Course course){
        PageInfo<Course> coursePageInfo = courseService.selectByAll(pageDomain,course);
        return pageTable(coursePageInfo.getList(),coursePageInfo.getTotal());
    }

    /**
     * 根据科目Id查询课程
     * @param id
     * @return
     */
    @GetMapping("/courseOfSubject/{id}")
    public ResuTable selectBySubjectId(@PathVariable Integer id){
        List<Course> courseList = courseService.selectBySubjectId(id);
        return dataTable(courseList);
    }
    /**
     * 插入新的课程
     * @param course
     * @return
     */
    @PostMapping
    public ResuBean insertCourse(Course course){
        return decide(courseService.insertCourse(course),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 修改课程信息
     * @param course
     * @return
     */
    @PutMapping
    public ResuBean updateCourse(Course course){
        return decide(courseService.updateCourse(course),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 删除课程
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean batchDelete(@PathVariable String ids){
        return decide(courseService.batchDelete(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

    /**
     * 浏览量加1
     * @param course
     * @return
     */
    @PutMapping("/addclick")
    public ResuBean updateCourseClick(Course course){
        return decide(courseService.updateCourseClick(course),
                MessageConstants.ADD_SUCCESS,
                MessageConstants.ADD_FAILURE);
    }
}
