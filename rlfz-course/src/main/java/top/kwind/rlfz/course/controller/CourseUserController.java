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
import top.kwind.rlfz.course.pojo.CourseUser;
import top.kwind.rlfz.course.service.CourseUserService;
import top.kwind.rlfz.rbac.pojo.User;

import java.util.List;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/9 17:28
 */
@RestController
@RequestMapping("api")
public class CourseUserController extends BaseController {

    @Autowired
    CourseUserService courseUserService;

    /**
     * 查询学生所拥有的课程
     * @param id
     * @return
     */
    @GetMapping("/courseOfStudent/{id}")
    public ResuTable getCoursesByUserId(@PathVariable Integer id){
        List<Course> courseList = courseUserService.getCoursesByUserId(id);
        return dataTable(courseList);
    }

    /**
     * 查询当前登录学生的课程
     * @return
     */
    @GetMapping("/coursesOfStudent")
    public ResuTable getCoursesByNowUserId(){
        List<Course> courseList = courseUserService.getCoursesByNowUserId();
        return dataTable(courseList);
    }

    /**
     * 查询某个课程下的所有学生
     * @param id
     * @return
     */
    @GetMapping("/studentOfCourse/{id}")
    public ResuTable getUsersByCourseId(@PathVariable Integer id, PageDomain pageDomain,User user){
        PageInfo<User> userPageInfo = courseUserService.getUsersByCourseId(pageDomain, id, user);
        return pageTable(userPageInfo.getList(),userPageInfo.getTotal());
    }

    /**
     * 为学生添加课程
     * @param courseUser
     * @return
     */
    @PostMapping("/addStudentCourse")
    public ResuBean insertUserCourse(CourseUser courseUser){
        return decide(courseUserService.insertUserCourse(courseUser),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 为用户删除课程
     * @param cId,sId
     * @return
     */
    @DeleteMapping("/delStudentCourse/{cId}/{sId}")
    public ResuBean deleteUserCourse(@PathVariable("cId")Integer cId,@PathVariable("sId") Integer sId){
        return decide(courseUserService.deleteUserCourse(cId,sId),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }

}
