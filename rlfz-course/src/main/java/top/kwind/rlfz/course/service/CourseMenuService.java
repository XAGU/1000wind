package top.kwind.rlfz.course.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.pojo.CourseMenu;
    /**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseMenuService{

        /**
        * 根据条件查询目录
        * @param pageDomain
        * @param courseMenu
        * @return
        */
    PageInfo<CourseMenu> selectByAll(PageDomain pageDomain, CourseMenu courseMenu);

        /**
         * 添加目录
         * @param courseMenu
         * @return
         */
    Boolean insertMenu(CourseMenu courseMenu);
    }
