package org.qidian.dao;

import org.qidian.modal.TContentHistory;
import org.qidian.modal.TContents;

public interface TContentHistoryMapper {
    int deleteByPrimaryKey(Integer historyId);

    int insert(TContentHistory record);

    int insertSelective(TContentHistory record);

    TContentHistory selectByPrimaryKey(Integer historyId);

    int updateByPrimaryKeySelective(TContentHistory record);

    int updateByPrimaryKey(TContentHistory record);

    /**
     * 插入历史记绿
    * @author 骆峰
    * @date 2018年4月8日 下午2:29:44
    * @param content
    * @return
     */
    int insertContent(TContents content);

    /**
     * 查询几次历史记绿
    * @author 骆峰
    * @date 2018年4月8日 下午4:09:42
    * @param cid
    * @return
     */
    Integer selectByHistoryCount(Integer cid);

    /**
     * 查询某一个版本信息
    * @author 骆峰
    * @date 2018年4月8日 下午5:45:14
    * @param tHistory
    * @return
     */
    TContents selectByHistory(TContentHistory tHistory);
}