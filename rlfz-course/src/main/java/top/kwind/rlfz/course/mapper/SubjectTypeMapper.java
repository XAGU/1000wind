package top.kwind.rlfz.course.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.course.pojo.SubjectType;

/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Mapper
public interface SubjectTypeMapper {
    int deleteByPrimaryKey(Integer subjectId);

    int insert(SubjectType record);

    int insertSelective(SubjectType record);

    SubjectType selectByPrimaryKey(Integer subjectId);

    int updateByPrimaryKeySelective(SubjectType record);

    int updateByPrimaryKey(SubjectType record);
}