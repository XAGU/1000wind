package top.kwind.rlfz.common.web.base;


import top.kwind.rlfz.common.web.domain.ResuBean;
import top.kwind.rlfz.common.web.domain.ResuTable;

/**
 * @author xagu
 */
public class BaseController {

    /**
     * Describe: 返回数据表格数据
     * Param data
     * Return 表格数据
     * */
    protected  static ResuTable dataTable(Object data){
        ResuTable resuTable = new ResuTable();
        resuTable.setCode(200);
        resuTable.setCount(0L);
        resuTable.setData(data);
        return resuTable;
    }

    /**
     * Describe: 返回数据表格数据 分页
     * Param data
     * Return 表格分页数据
     * */
    protected static ResuTable pageTable(Object data, long count){
        ResuTable resuTable = new ResuTable();
        resuTable.setData(data);
        resuTable.setCount(count);
        resuTable.setCode(200);
        return resuTable;
    }


    /**
     * Describe: 返回 ajax 接收成功消息
     * Param msg
     * Return ResuBean
     * */
    public static ResuBean success(String msg){
        ResuBean resuBean = new ResuBean();
        resuBean.setCode(200);
        resuBean.setSuccess(true);
        resuBean.setMsg(msg);
        return resuBean;
    }

    /**
     * Describe: 返回 ajax 接收失败消息
     * Param msg
     * Return ResuBean
     * */
    public static ResuBean failure(String msg){
        ResuBean resuBean = new ResuBean();
        resuBean.setCode(500);
        resuBean.setSuccess(false);
        resuBean.setMsg(msg);
        return resuBean;
    }

    /**
     * Describe: 根据 Boolean 自主返回 Success Failure 封装
     * Param msg
     * Return ResuBean
     * */
    public static ResuBean  decide(Boolean result,String success,String failure){
        if(result){
            return success(success);
        }else{
            return failure(failure);
        }
    }

}
