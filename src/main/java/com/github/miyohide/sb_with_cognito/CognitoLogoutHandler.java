package com.github.miyohide.sb_with_cognito;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class CognitoLogoutHandler extends SimpleUrlLogoutSuccessHandler {

  @Override
  protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
    String domain = resourceBundle.getString("app.cognito.domain");
    String logoutRedirectUrl = resourceBundle.getString("app.cognito.logout_uri");
    String userPoolClientId = resourceBundle.getString("spring.security.oauth2.client.registration.cognito.client-id");
    return UriComponentsBuilder
            .fromUri(URI.create(domain + "/logout"))
            .queryParam("client_id", userPoolClientId)
            .queryParam("logout_uri", logoutRedirectUrl)
            .encode(StandardCharsets.UTF_8)
            .build()
            .toUriString();
  }
}
