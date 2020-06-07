package top.kwind.rlfz.course.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.course.pojo.Course;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Mapper
public interface CourseMapper {

    List<Course> selectByAll(Course course);


}