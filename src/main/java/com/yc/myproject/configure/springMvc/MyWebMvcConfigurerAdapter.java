package com.yc.myproject.configure.springMvc;

import com.yc.myproject.interceptor.LevelInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SprinMVC拦截器配置
 * 如果Spring Boot提供的Sping MVC不符合要求，则可以通过一个配置类（注解有@Configuration的类）加上@EnableWebMvc注解来实现完全自己控制的MVC配置。
 * 在你既需要保留Spring Boot提供的便利，有需要增加自己的额外的配置的时候，可以定义一个配置类并继承WebMvcConfigurerAdapter,无需使用@EnableWebMvc注解。
 *
 * User: mcfell.yc
 * Date: 2017/9/13s
 * Time: 下午11:26
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LevelInterceptor()).addPathPatterns("/**").excludePathPatterns(
                "/user/login","/user/logout"
                ,"/user/admin/login","/user/admin/logout","/user/admin/add",
                "/admin/login","/");
        super.addInterceptors(registry);
    }
}
