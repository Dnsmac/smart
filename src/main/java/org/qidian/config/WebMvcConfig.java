package org.qidian.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 
   *  向mvc中添加自定义组件
   * @Project: smartKit-api   
   * @Description: TODO
   * @author 骆峰
   * @date 2018年3月23日 下午4:39:36
 */
@Configuration  
public class WebMvcConfig extends WebMvcConfigurationSupport {
    
    
    @Resource
    private BaseInterceptor baseInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
    }
    
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//         configurer.favorPathExtension(false);  /* 是否通过请求Url的扩展名来决定media type */
         
         /* 是否通过请求Url的扩展名来决定media type */
//         configurer.favorPathExtension(true)  
//                  /* 不检查Accept请求头 */
//                 .ignoreAcceptHeader(true)
//                 .parameterName("mediaType")
//                  /* 设置默认的media yype */
//                 .defaultContentType(MediaType.TEXT_HTML)
//                  /* 请求以.html结尾的会被当成MediaType.TEXT_HTML*/
//                 .mediaType("html", MediaType.TEXT_HTML)
//                 /* 请求以.json结尾的会被当成MediaType.APPLICATION_JSON*/
//                 .mediaType("json", MediaType.APPLICATION_JSON);
         
//     }
    
    /**
     * 配置静态资源处理
     * @param configurer
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 添加静态资源文件，外部可以直接访问地址
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");
//        super.addResourceHandlers(registry);
//    }
    
    
    
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      super.configureMessageConverters(converters);
      //1.需要定义一个convert转换消息的对象;
      FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
      //2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
      FastJsonConfig fastJsonConfig = new FastJsonConfig();
      fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
      //3处理中文乱码问题
      List<MediaType> fastMediaTypes = new ArrayList<>();
      fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
      //4.在convert中添加配置信息.
      fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
      fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
      //5.将convert添加到converters当中.
      converters.add(fastJsonHttpMessageConverter);
  }
}
