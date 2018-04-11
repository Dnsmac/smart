package org.qidian.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.qidian.constant.Url;
import org.qidian.constant.WebConst;
import org.qidian.controller.BaseController;
import org.qidian.dto.BaseDto;
import org.qidian.dto.Types;
import org.qidian.service.admin.SettingService;
import org.qidian.utils.MapCache;
import org.qidian.utils.TaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
   * 设置项 
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午6:43:57
 */
@Controller
public class SettingController extends BaseController {
    
    
    /**
     * 缓存
     */
    private MapCache cache = MapCache.single();
    
    /**
     * 设置模块
     */
    @Autowired
    private SettingService settingService;
    
    /**
     * 设置接口类型
    * @author 骆峰
    * @date 2018年4月9日 下午8:39:28
    * @param request
    * @param response
    * @param name
    * @return
     */
    @PostMapping(value=Url.Setting.SETTING_SERIES_SAVE)
    @ResponseBody
    public BaseDto saveSeriesSetting(HttpServletRequest request, HttpServletResponse response, String name){
        Integer uid = TaleUtils.getCookieUid(request);
        Integer projectId = cache.hget(String.valueOf(uid), Types.PROJECT_ID.getType());
        settingService.saveSeriesSetting(name, projectId);
        return WebConst.resultSuccess();
    }
    
    /**
     *  设置接口模块
    * @author 骆峰
    * @date 2018年4月9日 下午8:39:48
    * @param request
    * @param response
    * @param name
    * @return
     */
    @PostMapping(value=Url.Setting.SETTING_PROJECTTITLE_SAVE)
    @ResponseBody
    public BaseDto saveProjectSetting(HttpServletRequest request, HttpServletResponse response, String name){
        Integer uid = TaleUtils.getCookieUid(request);
        Integer categoryId = cache.hget(String.valueOf(uid), Types.CATEGORY_ID.getType());
        settingService.saveProjectSetting(name, categoryId);
        return WebConst.resultSuccess();
    }
    
    @PostMapping(value=Url.Setting.SETTING_CATEGORY_SAVE)
    @ResponseBody
    public BaseDto saveCategorySetting(HttpServletRequest request, HttpServletResponse response, String name){
        settingService.saveCategorySetting(name);
        
        Integer uid = TaleUtils.getCookieUid(request);
        cache.hdel(String.valueOf(uid), Types.TITLE_TYPE.getType());
        return WebConst.resultSuccess();
    }

}
