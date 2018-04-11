package org.qidian.dao;

import java.util.List;

import org.qidian.modal.ProjectTitle;

public interface ProjectTitleMapper {
    int deleteByPrimaryKey(Integer projectId);

    int insert(ProjectTitle record);

    int insertSelective(ProjectTitle record);

    ProjectTitle selectByPrimaryKey(Integer projectId);

    int updateByPrimaryKeySelective(ProjectTitle record);

    int updateByPrimaryKey(ProjectTitle record);

    /**
     * 
    * @author 骆峰
    * @date 2018年4月9日 下午3:01:30
    * @param categoryId
    * @return
     */
    List<ProjectTitle> selectByCategoryId(Integer categoryId);
}