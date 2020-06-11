package top.kwind.rlfz.practical.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Practical implements Serializable {
    /**
    * 	实训方案id
    */
    private Integer practicalId;

    /**
        * 	方案名
    */
    private String practicalName;

    /**
    * 	方案封面
    */
    private String practicalCover;

    /**
    * 实训科目类别
    */
    private Integer subjectId;

    /**
    * 	pdf方案链接
    */
    private String practicalUrl;

    /**
    * 	点击量
    */
    private Integer practicalClick;

    private static final long serialVersionUID = 1L;
}