package top.kwind.rlfz.rbac.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.kwind.rlfz.rbac.pojo.Power;

/**
 * @author xagu
 * Created on 2020/6/10
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PowerOfRole extends Power {
    private String checkArr = "0";

    private static final long serialVersionUID = 1L;
}
