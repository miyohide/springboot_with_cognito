package com.github.miyohide.sb_with_cognito;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class TenantRequestContext {
  private Integer tenantId;

  public Integer getTenantId() {
    return this.tenantId;
  }

  public void setTenantId(Integer tenantId) {
    this.tenantId = tenantId;
  }
}
