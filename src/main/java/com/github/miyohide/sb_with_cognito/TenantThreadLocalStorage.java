package com.github.miyohide.sb_with_cognito;

import java.util.UUID;

// リクエストごとに分離されたcustom:tenant_idを格納する変数を作成する
public class TenantThreadLocalStorage {
  private static ThreadLocal<String> tenant = new ThreadLocal<>();

  public static String getTenantIdString() {
    return tenant.get();
  }

  public static void setTenantId(String tenantId) {
    tenant.set(tenantId);
  }

  public static UUID getTenantId() {
    return UUID.fromString(tenant.get());
  }
}
