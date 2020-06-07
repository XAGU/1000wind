package top.kwind.rlfz.course.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import top.kwind.rlfz.course.mapper.CourseMenuMapper;
import top.kwind.rlfz.course.pojo.CourseMenu;
import top.kwind.rlfz.course.service.CourseMenuService;
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
    public int deleteByPrimaryKey(Integer menuId) {
        return courseMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(CourseMenu record) {
        return courseMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(CourseMenu record) {
        return courseMenuMapper.insertSelective(record);
    }

    @Override
    public CourseMenu selectByPrimaryKey(Integer menuId) {
        return courseMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(CourseMenu record) {
        return courseMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CourseMenu record) {
        return courseMenuMapper.updateByPrimaryKey(record);
    }

}
