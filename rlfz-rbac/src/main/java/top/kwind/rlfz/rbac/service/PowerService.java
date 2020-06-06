package top.kwind.rlfz.rbac.service;

import java.util.List;
import top.kwind.rlfz.rbac.pojo.Power;
public interface PowerService{


    int deleteByPrimaryKey(Integer powerId);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(Integer powerId);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);

    int updateBatch(List<Power> list);

    int updateBatchSelective(List<Power> list);

}
