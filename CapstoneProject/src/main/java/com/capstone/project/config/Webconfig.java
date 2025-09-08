package com.capstone.project.config;

import com.capstone.project.interseptor.InterceptorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//Interceptors can be registered by using WebMvcConfigurer (using addInterceptors)to apply to all requests or be limited to a subset of URL patterns.
@Configuration
public class Webconfig implements WebMvcConfigurer {

    @Autowired
    private InterceptorImp interceptorImp;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // WebMvcConfigurer.super.addInterceptors(registry); //this will register all the api path
        registry.addInterceptor(interceptorImp).addPathPatterns("/api/jobs/**").excludePathPatterns("/api/applications/**");//this will register only the api for jobs and exclude the api for application
        //** for nested path after the jobs.eg (/api/jobs/get/{id})
        //* the api is (api/jobs/{id})
    }
}
