package top.kwind.rlfz.course.pojo;

import java.io.Serializable;
import lombok.Data;
import top.kwind.rlfz.rbac.pojo.User;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Data
public class CourseUser implements Serializable {

    /**
    * 课程id
    */
    private Integer courseId;

    /**
    * 用户id
    */
    private Integer userId;

    private static final long serialVersionUID = 1L;
}