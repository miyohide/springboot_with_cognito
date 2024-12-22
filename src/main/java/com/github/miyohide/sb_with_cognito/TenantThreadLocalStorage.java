package com.github.miyohide.sb_with_cognito;

// リクエストごとに分離されたcustom:tenant_idを格納する変数を作成する
public class TenantThreadLocalStorage {
  private static ThreadLocal<String> tenant = new ThreadLocal<>();

  public static String getTenantId() {
    return tenant.get();
  }

  public static void setTenantId(String tenantId) {
    System.out.println("TenantThreadLocalStorage#setTenantId=" + tenantId);
    tenant.set(tenantId);
  }
}
