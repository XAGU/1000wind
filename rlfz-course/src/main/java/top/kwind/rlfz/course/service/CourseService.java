package top.kwind.rlfz.course.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.pojo.Course;
    /**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseService{
        /**
         * 根据条件查询课程
         * @param pageDomain
         * @param course
         * @return
         */
        PageInfo<Course> selectByAll(PageDomain pageDomain, Course course);
    }
