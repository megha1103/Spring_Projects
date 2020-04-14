package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cg.web.LoggerInterceptor;



@SpringBootApplication
public class SpringBootMvcApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}

	@Bean
	public HandlerInterceptor getLoggerInterceptor() {
		return new LoggerInterceptor();
	}

	@Bean
	public HandlerInterceptor getEmiInterceptor() {
		return new LoggerInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLoggerInterceptor());
		registry.addInterceptor(getEmiInterceptor()).addPathPatterns("/emisubmit");
	}

}
