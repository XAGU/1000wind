package top.kwind.rlfz.message.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.message.pojo.Message;
import top.kwind.rlfz.message.service.MessageService;

import javax.annotation.Resource;

/**
 * @author xagu
 * Created on 2020/6/7
 * Email:xagu_qc@foxmail.com
 * Describe: 通知
 */
@RestController
@RequestMapping("api/message")
public class MessageController extends BaseController {

    @Resource
    private MessageService messageService;

    /**
     * 根据条件查询所有
     *
     * @param message
     * @return
     */
    @GetMapping
    public ResuTable selectByAll(PageDomain pageDomain, Message message) {
        PageInfo<Message> messagePageInfo = messageService.selectByAll(pageDomain, message);
        return pageTable(messagePageInfo.getList(),messagePageInfo.getTotal());
    }

    /**
     * 添加消息
     * @param message
     * @return
     */
    @PostMapping
    public ResuBean insertMessage(Message message){
        return decide(messageService.insertMessage(message),
                MessageConstants.SAVE_SUCCESS,
                MessageConstants.SAVE_FAILURE);
    }

    /**
     * 更新message
     * @param message
     * @return
     */
    @PutMapping
    public ResuBean updateMessage(Message message){
        return decide(messageService.updateMessageById(message),
                MessageConstants.UPDATE_SUCCESS,
                MessageConstants.UPDATE_FAILURE);
    }

    /**
     * 通过id删除message
     * @param ids
     * @return
     */
    @DeleteMapping("{ids}")
    public ResuBean deleteMessage(@PathVariable String ids){
        return decide(messageService.deleteMessageById(ids.split(",")),
                MessageConstants.REMOVE_SUCCESS,
                MessageConstants.REMOVE_FAILURE);
    }
}
