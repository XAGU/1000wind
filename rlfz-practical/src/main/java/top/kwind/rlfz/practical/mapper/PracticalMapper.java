package top.kwind.rlfz.practical.mapper;
import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.practical.pojo.Practical;

import java.util.List;

@Mapper
public interface PracticalMapper {
    /**
     * 根据条件查询所有
     * @param practical
     * @return
     */
    List<Practical> selectByAll(Practical practical);

    /**
     * 添加practical
     * @param practical
     * @return
     */
    int insertPractical(Practical practical);

    /**
     * 更新practical
     * @param practical
     * @return
     */
    int updateByPractical(Practical practical);

    /**
     * 通过批量删除practical
     * @param ids
     * @return
     */
    int deleteById(String ids[] );

    /**
     * 点击量+1
     * @param id
     * @return
     */
    int updatePracticalClick(String id);

    /**
     * 根据科目Id查实训方案
     * @param id
     * @return
     */
    List<Practical> selectBySubjectId(Integer id);

}