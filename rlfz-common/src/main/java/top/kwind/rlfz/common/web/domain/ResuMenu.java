package top.kwind.rlfz.common.web.domain;

import lombok.Data;

/**
 * Describe: 前端菜单数据封装信息
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Data
public class ResuMenu {

    /**
     * 菜单编号
     * */
    private Integer id;

    /**
     * 标题
     * */
    private String title;

    /**
     * 菜单类型
     * */
    private Integer type;

    /**
     * 图标
     * */
    private String icon;

    /**
     * 跳转路径
     * */
    private String href;


    private Integer parentId;

}
