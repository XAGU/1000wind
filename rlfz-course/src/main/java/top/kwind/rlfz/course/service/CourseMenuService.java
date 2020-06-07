package top.kwind.rlfz.course.service;

import top.kwind.rlfz.course.pojo.CourseMenu;
    /**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseMenuService{


    int deleteByPrimaryKey(Integer menuId);

    int insert(CourseMenu record);

    int insertSelective(CourseMenu record);

    CourseMenu selectByPrimaryKey(Integer menuId);

    int updateByPrimaryKeySelective(CourseMenu record);

    int updateByPrimaryKey(CourseMenu record);

}
