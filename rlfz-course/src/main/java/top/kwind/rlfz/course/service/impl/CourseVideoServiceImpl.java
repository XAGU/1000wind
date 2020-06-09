package top.kwind.rlfz.course.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.common.web.domain.request.PageDomain;
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

    @Autowired
    CourseVideoMapper courseVideoMapper;

    @Override
    public PageInfo<CourseVideo> selectByAll(PageDomain pageDomain, CourseVideo courseVideo) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<>(courseVideoMapper.selectByAll(courseVideo));
    }

    @Override
    public Boolean insertVideo(CourseVideo courseVideo) {
        return courseVideoMapper.insertVideo(courseVideo) > 0;
    }

    @Override
    public Boolean updateVideo(CourseVideo courseVideo) {
        return courseVideoMapper.updateVideo(courseVideo) > 0;
    }

    @Override
    public Boolean deleteVideos(String[] ids) {
        return courseVideoMapper.deleteVideos(ids) > 0;
    }
}
