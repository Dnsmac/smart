package org.qidian.service.admin;

import org.qidian.dao.CategoryTypeMapper;
import org.qidian.dao.ProjectTitleMapper;
import org.qidian.dao.SeriesTypeMapper;
import org.qidian.modal.CategoryType;
import org.qidian.modal.ProjectTitle;
import org.qidian.modal.SeriesType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
   * 设置模块
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午7:09:16
 */
@Component
public class SettingService {

    
    @Autowired
    private SeriesTypeMapper seriesTypeMapper;
    
    @Autowired
    private ProjectTitleMapper projectTitleMapper;
    @Autowired
    private CategoryTypeMapper categoryTypeMapper;
    
    
    public void saveSeriesSetting(String name,  Integer projectId) {
        SeriesType st = new SeriesType();
        st.setName(name);
        st.setProjectId(projectId);
        seriesTypeMapper.insert(st);
    }


    public void saveProjectSetting(String name, Integer categoryId) {
        ProjectTitle project = new ProjectTitle();
        project.setCategoryId(categoryId);
        project.setProjectName(name);
        projectTitleMapper.insert(project);
    }


    public void saveCategorySetting(String name) {
        CategoryType category = new CategoryType();
        category.setCategoryName(name);
        categoryTypeMapper.insert(category);

    }

    

}
