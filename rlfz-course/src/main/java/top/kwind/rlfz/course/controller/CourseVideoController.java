package top.kwind.rlfz.course.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.course.pojo.CourseVideo;
import top.kwind.rlfz.course.service.CourseVideoService;

import java.util.List;

/**
 * @Author: HXC
 * @CreateDate: 2020/6/9 10:39
 */
@RestController
@RequestMapping("api/video")
public class CourseVideoController extends BaseController {

    @Autowired
    CourseVideoService courseVideoService;

    /**
     * 根据条件查询
     * @param pageDomain
     * @param courseVideo
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, CourseVideo courseVideo){
        PageInfo<CourseVideo> videoPageInfo = courseVideoService.selectByAll(pageDomain,courseVideo);
        return pageTable(videoPageInfo.getList(),videoPageInfo.getTotal());
    }

    @GetMapping("/videoOfMenu/{id}")
    public ResuTable selectByMenuId(@PathVariable Integer id){
        List<CourseVideo> videoList = courseVideoService.selectByMenuId(id);
        return dataTable(videoList);
    }

    /**
     * 新增视频
     * @param courseVideo
     * @return
     */
    @PostMapping
    public ResuBean insertVideo(CourseVideo courseVideo){
        return decide(courseVideoService.insertVideo(courseVideo),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 修改视频
     * @param courseVideo
     * @return
     */
    @PutMapping
    public ResuBean updateVideo(CourseVideo courseVideo){
        return decide(courseVideoService.updateVideo(courseVideo),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean deleteVideos(@PathVariable String[] ids){
        return decide(courseVideoService.deleteVideos(ids),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }
}
