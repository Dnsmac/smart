package org.qidian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qidian.constant.Url;
import org.qidian.constant.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *   首页
   * 
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午2:55:37
 */
@Controller
public class IndexController extends BaseController {
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = Url.LOGIN_VIEW)
    public String index(HttpServletRequest request, HttpServletResponse response) {
        if (getUid(request) >0){
            return "redirect:" +request.getContextPath()+Url.Admin.VIEW_INDEX;
        }
        return View.Login.LOGIN_VIEW;
    }
}
