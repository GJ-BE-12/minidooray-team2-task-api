package com.shoppingmall.shoppingmall.config;

import com.shoppingmall.shoppingmall.interceptor.MemberIdCheckInterceptor;
import com.shoppingmall.shoppingmall.interceptor.TaskIdCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private MemberIdCheckInterceptor memberIdCheckInterceptor;
    @Autowired
    private TaskIdCheckInterceptor taskIdCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberIdCheckInterceptor)
                .excludePathPatterns("/projects")
                .excludePathPatterns("/projects/by-member/**")
                .excludePathPatterns("/projects/{projectId}/members");
        registry.addInterceptor(taskIdCheckInterceptor)
                .addPathPatterns("/projects/{projectId}/tasks/{taskId}/comments/**")
                .addPathPatterns("/projects/{projectId}/tasks/{taskId}");
    }
}
