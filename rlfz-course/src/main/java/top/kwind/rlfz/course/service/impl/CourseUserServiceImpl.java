package top.kwind.rlfz.course.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import top.kwind.rlfz.course.pojo.CourseUser;
import top.kwind.rlfz.course.mapper.CourseUserMapper;
import top.kwind.rlfz.course.service.CourseUserService;
/**     
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

@Service
public class CourseUserServiceImpl implements CourseUserService{

    @Resource
    private CourseUserMapper courseUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return courseUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CourseUser record) {
        return courseUserMapper.insert(record);
    }

    @Override
    public int insertSelective(CourseUser record) {
        return courseUserMapper.insertSelective(record);
    }

    @Override
    public CourseUser selectByPrimaryKey(Integer id) {
        return courseUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CourseUser record) {
        return courseUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CourseUser record) {
        return courseUserMapper.updateByPrimaryKey(record);
    }

}
