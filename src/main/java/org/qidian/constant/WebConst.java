package org.qidian.constant;

import java.util.HashMap;
import java.util.Map;

import org.qidian.dto.BaseDto;
import org.springframework.stereotype.Component;



@Component
public class WebConst {
    public static Map<String, String> initConfig = new HashMap<>();


    public static String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "S_L_ID";

    /**
     * aes加密加盐
     */
    public static String AES_SALT = "0123456789abcdef";


    /**
     * 最大页码
     */
    public static final int MAX_PAGE = 100;


    /**
     * 上传文件最大1M
     */
    public static Integer MAX_FILE_SIZE = 1048576;
    

    /**
     * 成功返回状态码
     */
    public static String SUCCESS_RESULT = "SUCCESS";
    /**
     * 成功返回
     */
    public static Integer SUCCESS_CODE = 200;
    /**
     * 请求报错
     */
    public static Integer ERROR_CODE  = 500;
    
    
    /**
     * 失败返回
     */      
    public static String ERROR_RESULT = "ERROR";
    
    /**
     * 成功返回
     */
    public static BaseDto resultSuccess(){
        return new BaseDto(SUCCESS_CODE, SUCCESS_RESULT);
    }
    
    /**
     * 失败返回
     */
    public static BaseDto resultError(){
        return new BaseDto(ERROR_CODE, ERROR_RESULT);
    }
}
