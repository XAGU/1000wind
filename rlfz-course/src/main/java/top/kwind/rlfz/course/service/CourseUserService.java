package top.kwind.rlfz.course.service;

import top.kwind.rlfz.course.pojo.CourseUser;
    /**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseUserService{


    int deleteByPrimaryKey(Integer id);

    int insert(CourseUser record);

    int insertSelective(CourseUser record);

    CourseUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseUser record);

    int updateByPrimaryKey(CourseUser record);

}
