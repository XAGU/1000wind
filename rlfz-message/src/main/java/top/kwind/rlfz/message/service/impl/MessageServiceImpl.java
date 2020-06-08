package top.kwind.rlfz.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import top.kwind.rlfz.common.tools.DateUtils;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.message.mapper.MessageMapper;
import top.kwind.rlfz.message.pojo.Message;
import top.kwind.rlfz.message.service.MessageService;

import java.util.Date;

@Service("messageService")
public class MessageServiceImpl implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    @Override
    public PageInfo<Message> selectByAll(PageDomain pageDomain, Message message) {
        PageHelper.startPage(pageDomain.getPage(),pageDomain.getLimit());
        return new PageInfo<Message>(messageMapper.selectByAll(message));
    }

    @Override
    public Boolean insertMessage(Message message) {
        message.setCreateTime(DateUtils.getNowDate());
        return messageMapper.insertMessage(message)>0;
    }

    @Override
    public Boolean updateMessageById(Message message) {
        return messageMapper.updateById(message)>0;
    }

    @Override
    public Boolean deleteMessageById(String[] ids) {
        return messageMapper.deleteById(ids)>0;
    }
}
