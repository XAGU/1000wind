package top.kwind.rlfz.message.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.message.pojo.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    /**
     * 根据条件查询所有
     * @param message
     * @return
     */
    List<Message> selectByAll(Message message);


}