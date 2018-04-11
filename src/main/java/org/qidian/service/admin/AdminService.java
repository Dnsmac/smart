package org.qidian.service.admin;

import java.util.List;

import org.qidian.dao.SeriesTypeMapper;
import org.qidian.dto.SeriesTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    
    @Autowired
    private SeriesTypeMapper seriesTypeMapper;

    /**
     * 列表
    * @author 骆峰
    * @date 2018年4月8日 下午8:58:55
    * @param projectId
    * @return
     */
    public List<SeriesTypeVo> LookListView(int projectId) {
        return seriesTypeMapper.selectByprojectId(projectId);
    }

}
