package top.kwind.rlfz.course.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.pojo.CourseVideo;

import java.util.List;

/**
  * 
  * @Author:         HXC
  * @CreateDate:     2020/6/7 11:43
 */

public interface CourseVideoService{

        /**
         * 根据条件查询所有
         * @param courseVideo
         * @return
         */
        PageInfo<CourseVideo> selectByAll(PageDomain pageDomain,CourseVideo courseVideo);

        /**
         * 新增视频
         * @param courseVideo
         * @return
         */
        Boolean insertVideo(CourseVideo courseVideo);

        /**
         * 修改视频
         * @param courseVideo
         * @return
         */
        Boolean updateVideo(CourseVideo courseVideo);

        /**
         * 批量删除
         * @param ids
         * @return
         */
        Boolean deleteVideos(String[] ids);

        /**
         * 根据目录Id查视频
         * @param id
         * @return
         */
        List<CourseVideo> selectByMenuId(Integer id);
    }
