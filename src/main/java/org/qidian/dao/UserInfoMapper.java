package org.qidian.dao;

import java.util.List;

import org.qidian.modal.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoMapper {
    
    int deleteByPrimaryKey(Integer uid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    int countByName(UserInfo userInfoVo);

    List<UserInfo> selectByUserInfo(UserInfo userInfoVo);
}