package top.kwind.rlfz.rbac.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.pojo.User;

import java.util.List;

/**
 * @author xagu
 * Created on 2020/6/8
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserWithPower extends User {

    List<Power> powers;

    private static final long serialVersionUID = 1L;
}
