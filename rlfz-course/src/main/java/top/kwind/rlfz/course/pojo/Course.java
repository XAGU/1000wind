package top.kwind.rlfz.course.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

/**
    * 备注：课程类型共分为：实战进阶 技术公开课 毕设项目 毕设公开课 键值从0——3
    */
@Data
public class Course implements Serializable {
    /**
    * 	课程Id
    */
    private Integer courseId;

    /**
    * 	课程名
    */
    private String courseName;

    /**
    * 	课程介绍
    */
    private String courseInfo;

    /**
    * 	课程封面
    */
    private String courseCover;

    /**
    * 	点击量
    */
    private Integer courseClick;

    /**
    * 课程类型 可选0，1，2，3

    */
    private Byte courseStyle;

    /**
     *科目类型
     */
    private SubjectType subjectType;

    /**
    * 	创建时间
    */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}