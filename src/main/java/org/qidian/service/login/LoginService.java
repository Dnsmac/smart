package org.qidian.service.login;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.qidian.dao.CategoryTypeMapper;
import org.qidian.dao.ProjectTitleMapper;
import org.qidian.dao.UserInfoMapper;
import org.qidian.exception.TipException;
import org.qidian.modal.CategoryType;
import org.qidian.modal.ProjectTitle;
import org.qidian.modal.UserInfo;
import org.qidian.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 登录相关
   * 
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午5:11:18
 */
@Component
public class LoginService {
    
    
    /**
     * 账号
     */
    @Resource
    private UserInfoMapper UserInfoVo;
    
    @Autowired
    private ProjectTitleMapper projectTitleMapper;
    @Autowired
    private CategoryTypeMapper categoryTypeMapper;

    /**
     * 登录
    * @author 骆峰
    * @date 2018年3月28日 下午5:11:10
    * @param username
    * @param password
    * @return
     */
    public UserInfo login(String username, String password) {
        UserInfo userInfoVo = new UserInfo();
        userInfoVo.setUsername(username);
        
        
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        int count = UserInfoVo.countByName(userInfoVo);
        if (count < 1) {
            throw new TipException("不存在该用户");
        }
        String pwd = TaleUtils.MD5encode(username + password);
        userInfoVo.setPassword(pwd);
        List<UserInfo> userVos = UserInfoVo.selectByUserInfo(userInfoVo);
        
        if (userVos.size() != 1) {
            throw new TipException("用户名或密码错误");
        }
        return userVos.get(0);
    }

    /**
     * 
    * @author 骆峰
    * @date 2018年3月28日 下午5:11:02
    * @param uid
    * @return
     */
    public UserInfo queryUserById(Integer uid) {
        // TODO Auto-generated method stub
        return UserInfoVo.selectByPrimaryKey(uid);
    }
    
    
    
    public List<ProjectTitle> getProject(Integer categoryId){
        return projectTitleMapper.selectByCategoryId(categoryId);
    }
    
    public List<CategoryType> getCategory(){
        return categoryTypeMapper.selectByList();
    }

}
