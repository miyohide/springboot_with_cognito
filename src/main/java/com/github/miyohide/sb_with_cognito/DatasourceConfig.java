package com.github.miyohide.sb_with_cognito;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
  @Bean
  public TenantAwareDataSource datasource(@Value("${myapp.db.user}") String user, @Value("${myapp.db.password}") String password, @Value("${myapp.db.url}") String url) {
    return new TenantAwareDataSource(
            DataSourceBuilder.create().username(user).password(password).url(url).build()
    );
  }
}
