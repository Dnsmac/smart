package org.qidian.constant;

public interface View {

    /**
     * 
        *  登录 首页模板
       * @author 骆峰
       * @date 2018年3月28日 下午3:02:46
     */
     class Login{
         /** 首页 */
         public static final String LOGIN_VIEW = "admin/login";
         
    }
     
     /**
      * 内容详情
        * 
        * @Project: smartKit-api   
        * @Description: TODO
        * @author 骆峰
        * @date 2018年4月8日 上午11:44:22
      */
     class Editor{
         public static final String View = "admin/edit";
         
         public static final String UPDATE_View = "admin/update_edit";
         
         public static final String LookView = "admin/showEdit";
     }

     class Admin {
         
         public static final String View = "admin/list";
         
         public static final String VIEW_INDEX = "admin/index";
         
         public static final String LookView = "admin/showEdit";
     }
}
