package com.github.miyohide.sb_with_cognito;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

// リクエストの前処理でcustom:tenant_idを認証情報から取り出し、
// TenantThreadLocalStorageに格納する
@Component
public class RequestInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    // 認証情報を取り出す
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    // 認証情報からcustom:tenant_idを取り出す
    Jwt jwt = (Jwt) authentication.getPrincipal();
    Map<String, Object> map = jwt.getClaims();
    Object tenantIdObj = map.get("custom:tenant_id");

    if (tenantIdObj == null) {
      // custom:tenant_idを取得できない場合は401エラーを返す
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    } else {
      TenantThreadLocalStorage.setTenantId(tenantIdObj.toString());
      return true;
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    TenantThreadLocalStorage.setTenantId(null);
  }
}
