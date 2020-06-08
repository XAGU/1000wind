package top.kwind.rlfz.message.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import top.kwind.rlfz.message.pojo.Message;

import java.util.List;

/**
 * 消息通知dao层
 */

@Mapper
public interface MessageMapper {
    /**
     * 根据条件查询所有
     * @param message
     * @return
     */
    List<Message> selectByAll(Message message);

    /**
     * 添加message
     * @param message
     * @return
     */
    int insertMessage(Message message);

    /**
     * 更新message
     * @param message
     * @return
     */
    int updateById(Message message);

    /**
     * 通过id删除message
     * @param ids
     * @return
     */
    int deleteById(String[] ids);
}