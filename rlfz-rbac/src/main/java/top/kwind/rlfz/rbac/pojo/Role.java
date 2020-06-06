package top.kwind.rlfz.rbac.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Role implements Serializable {
    /**
    * 	角色Id
    */
    private Integer roleId;

    /**
    * 角色名
    */
    private String roleName;

    /**
    * 	角色标识
    */
    private String roleCode;

    /**
    * 	角色是否可用
    */
    private Byte enable;

    /**
    * 	创建时间
    */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}