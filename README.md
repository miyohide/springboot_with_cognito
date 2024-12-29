# これは何か？

Amazon Cognito 統合とマルチテナントのサポートを備えた Spring Boot アプリケーション

このプロジェクトは、認証のための Amazon Cognito との統合を実証し、テナント対応データソースを使用してマルチテナントのサポートを実装する Spring Boot を使ったサンプルアプリケーションです。

このアプリケーションは、ユーザーが Amazon Cognito を使用して認証し、テナント固有のデータにアクセスできる安全なマルチテナント環境を提供します。 Spring Security を OAuth2 統合に活用し、テナント コンテキスト管理のためのカスタム リクエスト インターセプトを実装します。

データベースの初期設定として、以下を実行する必要があります。

```sql
CREATE USER mt_user WITH PASSWORD 'mt_user';
GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES ON ALL TABLES IN SCHEMA public TO mt_user;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO mt_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT, INSERT, UPDATE, DELETE, REFERENCES ON TABLES TO mt_user;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT USAGE, SELECT ON SEQUENCES TO mt_user;
```