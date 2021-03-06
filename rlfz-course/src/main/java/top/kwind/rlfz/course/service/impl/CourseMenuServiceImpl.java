package top.kwind.rlfz.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.mapper.CourseMenuMapper;
import top.kwind.rlfz.course.pojo.CourseMenu;
import top.kwind.rlfz.course.service.CourseMenuService;

import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class CourseMenuServiceImpl implements CourseMenuService{

    @Resource
    private CourseMenuMapper courseMenuMapper;

    @Override
    public PageInfo<CourseMenu> selectByAll(PageDomain pageDomain, CourseMenu courseMenu) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(courseMenuMapper.selectByAll(courseMenu));
    }

    @Override
    public Boolean insertMenu(CourseMenu courseMenu) {
        return courseMenuMapper.insertMenu(courseMenu) > 0;
    }

    @Override
    public Boolean updateMenu(CourseMenu courseMenu) {
        return courseMenuMapper.updateMenu(courseMenu) > 0;
    }

    @Override
    public Boolean deleteMenus(String[] ids) {
        return courseMenuMapper.deleteMenus(ids) > 0;
    }

    @Override
    public List<CourseMenu> selectByCourseId(Integer id,CourseMenu menu) {
        return courseMenuMapper.selectByCourseId(id,menu);
    }

}
