package org.qidian.dto;

import java.io.Serializable;
import java.util.List;

import org.qidian.modal.TContents;

public class SeriesTypeVo  implements Serializable{

    /** @Fields serialVersionUID : */
    private static final long serialVersionUID = 1L;
    
    private Integer seriesId;

    /**
     * 项目
     */
    private Integer projectId;

    /**
     * 名称
     */
    private String name;
    
    /**
     * 内容
     */
    private List<TContents> tContents;

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TContents> gettContents() {
        return tContents;
    }

    public void settContents(List<TContents> tContents) {
        this.tContents = tContents;
    }
    
    

}
