package top.kwind.rlfz.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.course.pojo.CourseMenu;

import java.util.List;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Mapper
public interface CourseMenuMapper {

    /**
     * 根据条件查询所有
     *
     * @param courseMenu
     * @return
     */
    List<CourseMenu> selectByAll(CourseMenu courseMenu);

    /**
     * 添加目录
     *
     * @param courseMenu
     * @return
     */
    int insertMenu(CourseMenu courseMenu);

    /**
     * 修改课程目录
     *
     * @param courseMenu
     * @return
     */
    int updateMenu(CourseMenu courseMenu);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteMenus(String[] ids);

    /**
     * 根据课程id查询目录
     * @param id
     * @return
     */
    List<CourseMenu> selectByCourseId(Integer id);
}