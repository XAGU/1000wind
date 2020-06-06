package top.kwind.rlfz.rbac.pojo;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserRole implements Serializable {
    /**
    * 关联id

    */
    private Integer id;

    /**
    * 	用户id
    */
    @NonNull
    private Integer userId;

    /**
    * 	角色id
    */
    @NonNull
    private Integer roleId;

    private static final long serialVersionUID = 1L;
}