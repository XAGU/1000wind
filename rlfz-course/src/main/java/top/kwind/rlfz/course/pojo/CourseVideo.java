package top.kwind.rlfz.course.pojo;

import java.io.Serializable;
import lombok.Data;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Data
public class CourseVideo implements Serializable {
    /**
    * 视频id
    */
    private Integer vedioId;

    /**
    * 	视频名
    */
    private String vedioName;

    /**
    * 	视频url
    */
    private String vedioUrl;

    /**
    * 	目录id
    */
    private Integer menuId;

    private static final long serialVersionUID = 1L;

}