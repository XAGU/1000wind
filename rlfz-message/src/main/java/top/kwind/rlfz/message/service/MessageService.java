package top.kwind.rlfz.message.service;

import com.github.pagehelper.PageInfo;
import top.kwind.rlfz.common.web.domain.request.PageDomain;
import top.kwind.rlfz.message.pojo.Message;

public interface MessageService{


    /**
     * 根据条件查询所有
     * @param pageDomain
     * @param message
     * @return
     */
    PageInfo<Message> selectByAll(PageDomain pageDomain, Message message);
}
