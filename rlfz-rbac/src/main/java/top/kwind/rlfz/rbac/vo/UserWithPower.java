package top.kwind.rlfz.rbac.vo;

import lombok.Data;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.pojo.User;

import java.util.List;

/**
 * @author xagu
 * Created on 2020/6/8
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@Data
public class UserWithPower extends User {

    List<Power> powers;
}
