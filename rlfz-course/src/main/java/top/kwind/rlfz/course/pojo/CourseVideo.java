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
    private Integer videoId;

    /**
    * 	视频名
    */
    private String videoName;

    /**
    * 	视频url
    */
    private String videoUrl;

    /**
    * 	目录,多个视频对应一个目录
    */
    private CourseMenu courseMenu;

    private static final long serialVersionUID = 1L;

}