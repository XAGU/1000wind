package top.kwind.rlfz.message.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwind.rlfz.common.web.base.BaseController;
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
}
