package org.qidian.dao;

import java.util.List;

import org.qidian.modal.CategoryType;

public interface CategoryTypeMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(CategoryType record);

    int insertSelective(CategoryType record);

    CategoryType selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(CategoryType record);

    int updateByPrimaryKey(CategoryType record);

    /**
     * 
    * @author 骆峰
    * @date 2018年4月9日 下午3:06:04
    * @return
     */
    List<CategoryType> selectByList();
}