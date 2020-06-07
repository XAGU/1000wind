package top.kwind.rlfz.course.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import top.kwind.rlfz.course.mapper.SubjectTypeMapper;
import top.kwind.rlfz.course.pojo.SubjectType;
import top.kwind.rlfz.course.service.SubjectTypeService;
/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class SubjectTypeServiceImpl implements SubjectTypeService{

    @Resource
    private SubjectTypeMapper subjectTypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer subjectId) {
        return subjectTypeMapper.deleteByPrimaryKey(subjectId);
    }

    @Override
    public int insert(SubjectType record) {
        return subjectTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(SubjectType record) {
        return subjectTypeMapper.insertSelective(record);
    }

    @Override
    public SubjectType selectByPrimaryKey(Integer subjectId) {
        return subjectTypeMapper.selectByPrimaryKey(subjectId);
    }

    @Override
    public int updateByPrimaryKeySelective(SubjectType record) {
        return subjectTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SubjectType record) {
        return subjectTypeMapper.updateByPrimaryKey(record);
    }

}
