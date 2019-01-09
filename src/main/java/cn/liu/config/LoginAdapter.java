package cn.liu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.liu.interceptor.LoginInterceptor;

/**
 * 登录拦截
 * @author liu
 */
@SpringBootConfiguration
public class LoginAdapter extends WebMvcConfigurerAdapter {
	@Autowired
    LoginInterceptor loginInterceptor;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
    	//addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        /*registry.addInterceptor(loginInterceptor)
        		.addPathPatterns("/**")
        		//.excludePathPatterns("/error")
        		.excludePathPatterns("/system/login")
        		.excludePathPatterns("/system/register")
        		.excludePathPatterns("/upload/page"); //测试用，稍后注释
        		//.excludePathPatterns("/upload/doUpload"); //测试用，稍后注释
        super.addInterceptors(registry);*/
    }
}
