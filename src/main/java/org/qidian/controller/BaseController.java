package org.qidian.controller;


import javax.servlet.http.HttpServletRequest;

import org.qidian.modal.UserInfo;
import org.qidian.utils.TaleUtils;

/**
 * Created by 13 on 2017/2/21.
 */
public abstract class BaseController {



    /**
     * 获取请求绑定的登录对象
     * 返回当前登录用户
     * @param request
     * @return
     */
    public UserInfo user(HttpServletRequest request) {
      try {
          return TaleUtils.getLoginUser(request);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
       
    }

    /**
     * 登录UID
    * @author 骆峰
    * @date 2018年3月28日 下午5:06:00
    * @param request
    * @return
     */
    public Integer getUid(HttpServletRequest request){
        Integer uid =  0;
        try {
             uid = this.user(request).getUid();
        } catch (Exception e) {
            e.printStackTrace();
            uid =  0;
        }
        return uid;
    }

}
