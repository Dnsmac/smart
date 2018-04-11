package org.qidian.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.qidian.constant.Url;
import org.qidian.constant.View;
import org.qidian.controller.BaseController;
import org.qidian.dto.SeriesTypeVo;
import org.qidian.dto.Types;
import org.qidian.modal.ProjectTitle;
import org.qidian.service.admin.AdminService;
import org.qidian.service.login.LoginService;
import org.qidian.utils.MapCache;
import org.qidian.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class AdminController  extends BaseController {
    
    /**
     * 缓存
     */
    private MapCache cache = MapCache.single();
    
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private AdminService adminService;
    /**
     * 列表
    * @author 骆峰
    * @date 2018年4月8日 下午8:42:39
    * @param id
    * @param map
    * @return
     */
    @GetMapping(value=Url.Admin.View)
    public String LookListView(HttpServletRequest request,  @PathVariable(value = "projectId") int projectId, Model map){
        Integer uid = TaleUtils.getCookieUid(request);
        List<SeriesTypeVo> vo =  adminService.LookListView(projectId);
        cache.hset(String.valueOf(uid), Types.PROJECT_ID.getType(), projectId);
        map.addAttribute("vo", vo);
        return View.Admin.View ;
    }
    
    /**
     * 导航页
    * @author 骆峰
    * @date 2018年4月9日 下午7:39:36
    * @return
     */
    @GetMapping(value=Url.Admin.VIEW_INDEX)
    public String indexView(){
        return View.Admin.VIEW_INDEX ;
    }
    
    /**
     * 项目
    * @author 骆峰
    * @date 2018年4月9日 下午7:39:21
    * @param request
    * @param categoryId
    * @return
     */
    @GetMapping(value=Url.Admin.VIEW_PROJECT)
    public String projectView(HttpServletRequest request, @PathVariable(value = "categoryId") int categoryId){
        Integer uid = TaleUtils.getCookieUid(request);
        List<ProjectTitle> project = loginService.getProject(categoryId);
        cache.hset(String.valueOf(uid), Types.CATEGORY_ID.getType(), categoryId);
        if (project.size() != 0){
            return "redirect:" +request.getContextPath()+"/admin/view/"+project.get(0).getProjectId();
        }
        cache.hdel(String.valueOf(uid), Types.PROJECT_TYPE.getType());
        cache.hdel(String.valueOf(uid), Types.PROJECT_ID.getType());
        return View.Admin.View ;
    }
    
    

}
