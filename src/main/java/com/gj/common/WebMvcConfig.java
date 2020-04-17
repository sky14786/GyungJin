package com.gj.common;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		final List<String> URL_PATTERNS = Arrays.asList("/", "/view/**");
		registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/api/**").excludePathPatterns(URL_PATTERNS);
		registry.addInterceptor(new JwtInterceptor()).addPathPatterns("/api/**");
	}

}
