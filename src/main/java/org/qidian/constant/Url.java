package org.qidian.constant;


/**
 * url
   * 
   * @Project: my-blog   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月28日 下午3:02:06
 */
public interface Url {
    
    
    /** 首页 */
    public static final String LOGIN_VIEW = "";
    
    /**
     * 
        *  登录 首页Url
       * @author 骆峰
       * @date 2018年3月28日 下午3:02:46
     */
     class Login{
         /**
          * 请求登录  登录成功
          */
        public static final String  LOGIN = "/login/index";
        /**
         * 请求登录  登录成功
         */
        public static final String  POST_LOGIN = "admin/login";
    }
     
     
     /**
      * 
        *  设置页面
        * @Project: smartKit-api   
        * @Description: TODO
        * @author 骆峰
        * @date 2018年3月28日 下午7:16:56
      */
     class Setting {
         
         public static final String View = "/Setting/view";
         
         
         public static final String SETTING_SERIES_SAVE = "/save/series"; 
         
         public static final String SETTING_PROJECTTITLE_SAVE = "/save/projectTitle"; 
         
         public static final String SETTING_CATEGORY_SAVE = "/save/CategoryType"; 
     }
     
     
     /**
      * 
        *  文本编辑查看 
        * @Project: smartKit-api   
        * @Description: TODO
        * @author 骆峰
        * @date 2018年4月8日 下午8:40:58
      */
     class Editor{
         public static final String View = "/Editor/view/{seriesId}/{projectId}";
         
         public static final String UPDATE_View = "/Editor/view/update/{cid}";
         
         public static final String LookView = "/Editor/look/{id}";
         
         public static final String  Save =  "/Editor/save";
     }
     
     /**
      * 
        *  列表
        * @Project: smartKit-api   
        * @Description: TODO
        * @author 骆峰
        * @date 2018年4月8日 下午8:41:28
      */
     class Admin{
         //列表
         public static final String View = "/admin/view/{projectId}";
         
         public static final String LookView = "/admin/look/{id}";
         
         public static final String  Save =  "/admin/save";
         
         
         public static final String  VIEW_INDEX =  "/admin/index";
         
         public static final String  VIEW_PROJECT =  "/admin/project/{categoryId}";
     }
     
     

}
