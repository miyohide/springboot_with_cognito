package com.github.miyohide.sb_with_cognito;

import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@Controller
public class MyController {
  @GetMapping("/")
  public String index(Model model) {
    return "home";
  }
  @GetMapping("/hello")
  public String hello(Model model) {
    return "hello";
  }
//  // 最新の属性情報を取得するためのRESTful操作の基本セット
//  private final RestOperations restOperations = new RestTemplate();
//  // OAuth 2.0クライアントの認証情報を永続化および管理するためのインターフェースが`OAuth2AuthorizedClientService`
//  private final OAuth2AuthorizedClientService service;
//
//  public MyController(OAuth2AuthorizedClientService service) {
//    this.service = service;
//  }
//
//  @GetMapping("/attributes")
//  public String userAttributeAtLogin(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) {
//    // 認証されたユーザー`Princiapl`をコントローラーのメソッド引数として取得できるアノテーション
//    // `@AuthenticationPrincipal`を使って情報を取得している。
//    model.addAttribute("attributes", oAuth2User.getAttributes());
//    return "userinfo";
//  }
//
//  /**
//   * 最新のユーザ属性を取得する
//   * @param authentication OAuth 2.0認証を使用する際に利用されるトークン
//   * @param model Viewのモデル
//   * @return 描画するThymeleafのテンプレート名
//   */
//  @GetMapping("/attributes/latest")
//  public String userLatestAttribute(OAuth2AuthenticationToken authentication, Model model) {
//    OAuth2AuthorizedClient oAuth2AuthorizedClient = this.getAuthorizedClient(authentication);
//    // ユーザー属性の取得ができるエンドポイントを取得する
//    String userInfoUri = oAuth2AuthorizedClient.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();
//    // 認証時に取得したアクセストークンを付与してRestTemplateを使用して最新のユーザー属性を取得している
//    RequestEntity<Void> requestEntity = RequestEntity.get(URI.create(userInfoUri))
//            .header(HttpHeaders.AUTHORIZATION, "Bearer " + oAuth2AuthorizedClient.getAccessToken().getTokenValue())
//            .build();
//    model.addAttribute("attributes", restOperations.exchange(requestEntity, Map.class).getBody());
//    return "userinfo";
//  }
//
//  /**
//   * OAuth 2.0認証を使用する際に利用されるトークン`OAuth2AuthenticationToken`を使って認証済みのクライアントに
//   * 関する情報を保持する`OAuth2AuthorizedClient`のインスタンスを返す
//   * @param authentication OAuth 2.0認証を使用する際に利用されるトークン
//   * @return 認証済みのクライアントに関する情報を保持しているインスタンス
//   */
//  private OAuth2AuthorizedClient getAuthorizedClient(OAuth2AuthenticationToken authentication) {
//    return this.service.loadAuthorizedClient(
//            authentication.getAuthorizedClientRegistrationId(), authentication.getName()
//    );
//  }
}
