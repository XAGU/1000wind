package top.kwind.rlfz.course.pojo;

import java.io.Serializable;
import lombok.Data;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Data
public class CourseMenu implements Serializable {
    /**
    * 目录id
    */
    private Integer menuId;

    /**
    * 目录名
    */
    private String menuName;

    /**
    * 	课程id
    */
    private Integer courseId;

    private static final long serialVersionUID = 1L;
}