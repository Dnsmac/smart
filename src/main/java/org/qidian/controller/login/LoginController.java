package org.qidian.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.qidian.constant.Url;
import org.qidian.constant.WebConst;
import org.qidian.controller.BaseController;
import org.qidian.dto.BaseDto;
import org.qidian.exception.TipException;
import org.qidian.modal.UserInfo;
import org.qidian.service.login.LoginService;
import org.qidian.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *   首页 登录 模块
   * 
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午2:55:37
 */
@Controller
public class LoginController extends BaseController {
    

    /**
     * 登录模块
     */
    @Autowired
    private LoginService loginService;
    
    
    
    
    /**
     * 登录
     * @author 骆峰
     * @date 2018年3月28日 下午4:35:49
     * @param username  用户名
     * @param password  密码
     * @param remeber_me  是否记住密码
     * @return BaseDto
     */
    @PostMapping(value = Url.Login.POST_LOGIN)
    @ResponseBody
    public BaseDto Login(@RequestParam String username,
            @RequestParam String password,
            @RequestParam(required = false) String remeber_me,
            HttpServletRequest request,
            HttpServletResponse response) {
        
        try {
            UserInfo  user = loginService.login(username, password);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            if (StringUtils.isNotBlank(remeber_me)) {
                TaleUtils.setCookie(response, user.getUid());
            }
        } catch (Exception e) {
            String msg = WebConst.ERROR_RESULT;
            e.printStackTrace();
            if (e instanceof TipException) {
                msg = e.getMessage();
            }
            return new BaseDto(WebConst.ERROR_CODE,  msg);
        }
        return new BaseDto(WebConst.SUCCESS_CODE, WebConst.SUCCESS_RESULT);
    }
    
    
    
    
    
}
