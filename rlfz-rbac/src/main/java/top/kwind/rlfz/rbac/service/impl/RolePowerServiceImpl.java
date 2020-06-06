package top.kwind.rlfz.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import top.kwind.rlfz.rbac.pojo.RolePower;
import top.kwind.rlfz.rbac.mapper.RolePowerMapper;
import top.kwind.rlfz.rbac.service.RolePowerService;
@Service
public class RolePowerServiceImpl implements RolePowerService{

    @Resource
    private RolePowerMapper rolePowerMapper;


}
