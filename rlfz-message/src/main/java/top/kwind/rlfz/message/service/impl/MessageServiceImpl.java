package top.kwind.rlfz.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.message.mapper.MessageMapper;
import top.kwind.rlfz.message.pojo.Message;
import top.kwind.rlfz.message.service.MessageService;
@Service("messageService")
public class MessageServiceImpl implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    @Override
    public PageInfo<Message> selectByAll(PageDomain pageDomain, Message message) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<Message>(messageMapper.selectByAll(message));
    }
}
