package top.kwind.rlfz.course.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.pojo.CourseMenu;
import top.kwind.rlfz.course.service.CourseMenuService;

import java.util.List;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/8 19:59
 */
@RestController
@RequestMapping("api/menu")
public class CourseMenuController extends BaseController {

    @Autowired
    CourseMenuService courseMenuService;

    /**
     * 根据条件查询课程目录
     * @param pageDomain
     * @param courseMenu
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, CourseMenu courseMenu){
        PageInfo<CourseMenu> menuPageInfo = courseMenuService.selectByAll(pageDomain,courseMenu);
        return pageTable(menuPageInfo.getList(),menuPageInfo.getTotal());
    }

    /**
     * 根据课程id查询目录
     * @param id
     * @return
     */
    @GetMapping("/menuOfCourse/{id}")
    public ResuTable selectByCourseId(@PathVariable Integer id,CourseMenu menu){
        List<CourseMenu> menuList = courseMenuService.selectByCourseId(id,menu);
        return dataTable(menuList);
    }

    /**
     * 添加目录
     * @param courseMenu
     * @return
     */
    @PostMapping
    public ResuBean insertMenu(CourseMenu courseMenu){
        return decide(courseMenuService.insertMenu(courseMenu),
                    MessageConstants.SAVE_SUCCESS,
                    MessageConstants.SAVE_FAILURE);
    }

    /**
     * 修改目录
     *
     * @param courseMenu
     * @return
     */
    @PutMapping
    public ResuBean updateMenu(CourseMenu courseMenu){
        return decide(courseMenuService.updateMenu(courseMenu),
                    MessageConstants.UPDATE_SUCCESS,
                    MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 删除目录
     *
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean deleteMenus(@PathVariable String[] ids){
        return decide(courseMenuService.deleteMenus(ids),
                    MessageConstants.REMOVE_SUCCESS,
                    MessageConstants.REMOVE_FAILURE);
    }
}
