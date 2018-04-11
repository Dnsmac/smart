package org.qidian.service.admin;

import org.qidian.constant.WebConst;
import org.qidian.dao.TContentHistoryMapper;
import org.qidian.dao.TContentsMapper;
import org.qidian.dto.BaseDto;
import org.qidian.modal.TContentHistory;
import org.qidian.modal.TContents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorService {
    
    
    @Autowired
    private TContentsMapper tContentsMapper;
    @Autowired
    private TContentHistoryMapper tContentHistoryMapper;

    /**
     * 接口内容新增保存
    * @author 骆峰
    * @date 2018年4月8日 下午2:39:49
    * @param content
    * @return
     */
    public BaseDto saveEditorContent( TContents content) {
        if (content.getCid() != null){
            Integer count = tContentHistoryMapper.selectByHistoryCount(content.getCid());
            content.setVersions((count+1)+"");
            content.setModified(System.currentTimeMillis());
            tContentsMapper.updateByPrimaryKeySelective(content);
        }
        else{
            content.setVersions("1");
            content.setCreated(System.currentTimeMillis());
            tContentsMapper.insert(content);
        }
        content.setCreated(System.currentTimeMillis());
        tContentHistoryMapper.insertContent(content);
        return WebConst.resultSuccess();
    }

    /**
     * 查询接口信息
    * @author 骆峰
    * @date 2018年4月8日 下午5:35:49
    * @param id
    * @return
     */
    public TContents LookEditorView(int id, String versions) {
        if (null ==versions){
            return tContentsMapper.selectByPrimaryKey(id);
        } else {
            TContentHistory tHistory = new TContentHistory();
            tHistory.setCid(id);
            tHistory.setVersions(versions);
            return tContentHistoryMapper.selectByHistory(tHistory);
        }
    }

    public TContents editorUpdateView(int cid) {
        return tContentsMapper.selectByPrimaryKey(cid);
        
    }

}
