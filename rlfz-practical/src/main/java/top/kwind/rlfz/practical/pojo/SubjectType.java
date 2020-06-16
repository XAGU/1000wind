package top.kwind.rlfz.practical.pojo;

import lombok.Data;

import java.io.Serializable;


@Data
public class SubjectType implements Serializable {
    /**
    * 分类id
    */
    private Integer subjectId;

    /**
    * 科目类别名
    */
    private String subjectName;

    private static final long serialVersionUID = 1L;
}