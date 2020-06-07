package top.kwind.rlfz.course.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import top.kwind.rlfz.course.mapper.CourseVideoMapper;
import top.kwind.rlfz.course.pojo.CourseVideo;
import top.kwind.rlfz.course.service.CourseVideoService;
/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class CourseVideoServiceImpl implements CourseVideoService{

    @Resource
    private CourseVideoMapper courseVideoMapper;

    @Override
    public int deleteByPrimaryKey(Integer vedioId) {
        return courseVideoMapper.deleteByPrimaryKey(vedioId);
    }

    @Override
    public int insert(CourseVideo record) {
        return courseVideoMapper.insert(record);
    }

    @Override
    public int insertSelective(CourseVideo record) {
        return courseVideoMapper.insertSelective(record);
    }

    @Override
    public CourseVideo selectByPrimaryKey(Integer vedioId) {
        return courseVideoMapper.selectByPrimaryKey(vedioId);
    }

    @Override
    public int updateByPrimaryKeySelective(CourseVideo record) {
        return courseVideoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CourseVideo record) {
        return courseVideoMapper.updateByPrimaryKey(record);
    }

}
