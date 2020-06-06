package top.kwind.rlfz.rbac.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import top.kwind.rlfz.rbac.pojo.Power;
import top.kwind.rlfz.rbac.mapper.PowerMapper;
import top.kwind.rlfz.rbac.service.PowerService;
@Service
public class PowerServiceImpl implements PowerService{


    @Override
    public int deleteByPrimaryKey(Integer powerId) {
        return 0;
    }

    @Override
    public int insert(Power record) {
        return 0;
    }

    @Override
    public int insertSelective(Power record) {
        return 0;
    }

    @Override
    public Power selectByPrimaryKey(Integer powerId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Power record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Power record) {
        return 0;
    }

    @Override
    public int updateBatch(List<Power> list) {
        return 0;
    }

    @Override
    public int updateBatchSelective(List<Power> list) {
        return 0;
    }
}
