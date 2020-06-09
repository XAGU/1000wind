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

    /**
     * 根据条件查询所有
     *
     * @param course
     * @return
     */
    List<Course> selectByAll(Course course);

    /**
     * 添加课程
     *
     * @param course
     * @return
     */
    int insertCourse(Course course);

    /**
     * 修改课程
     *
     * @param course
     * @return
     */
    int updateCourse(Course course);

    /**
     * 批量删除课程
     *
     * @param ids
     * @return
     */
    int batchDelete(String[] ids);

    /**
     * 点击量+1
     *
     * @param course
     * @return
     */
    int updateCourseClick(Course course);

    /**
     * 根据科目Id查询课程
     * @param id
     * @return
     */
    List<Course> selectBySubjectId(Integer id);
}