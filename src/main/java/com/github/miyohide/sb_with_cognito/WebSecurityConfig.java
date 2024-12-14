package com.github.miyohide.sb_with_cognito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    CognitoLogoutHandler cognitoLogoutHandler = new CognitoLogoutHandler();

    http
            .csrf(Customizer.withDefaults())
            .authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/home").permitAll()
                    .anyRequest().authenticated())
            .oauth2Login(Customizer.withDefaults())
            .logout(logout -> logout.logoutSuccessHandler(cognitoLogoutHandler));
    return http.build();
  }
}
