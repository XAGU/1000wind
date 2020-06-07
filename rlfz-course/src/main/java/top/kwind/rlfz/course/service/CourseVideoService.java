package top.kwind.rlfz.course.service;

import top.kwind.rlfz.course.pojo.CourseVideo;
    /**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseVideoService{


    int deleteByPrimaryKey(Integer vedioId);

    int insert(CourseVideo record);

    int insertSelective(CourseVideo record);

    CourseVideo selectByPrimaryKey(Integer vedioId);

    int updateByPrimaryKeySelective(CourseVideo record);

    int updateByPrimaryKey(CourseVideo record);

}
