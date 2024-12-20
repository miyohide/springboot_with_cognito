package com.github.miyohide.sb_with_cognito;

// リクエストごとに分離されたcustom:tenant_idを格納する変数を作成する
public class TenantThreadLocalStorage {
  private static ThreadLocal<Integer> tenant = new ThreadLocal<>();

  public static Integer getTenantId() {
    return tenant.get();
  }

  public static void setTenantId(Integer tenantId) {
    tenant.set(tenantId);
  }
}
