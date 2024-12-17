package com.github.miyohide.sb_with_cognito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// interceptorを登録する
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  @Bean
  RequestInterceptor requestInterceptor() {
    return new RequestInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(requestInterceptor());
  }
}
