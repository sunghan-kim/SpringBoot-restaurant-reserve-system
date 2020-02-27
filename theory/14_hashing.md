# 14. Hashing

- 임의의 길이의 데이터를 정해진 길이의 데이터로 변환하는 작업

<br>

## 14.1 BCrypt

- 여러 가지의 hashing 방법 중 하나
- 이 것을 통해 비밀번호를 암호화한다.
- BCrypt는 한 방향으로만 hashing하기 때문에 절대로 원래의 비밀번호를 알아낼 수 없다.

<br>

## 14.2 Spring Security

- 이 것을 이용해 암호화와 같은 사용자에 대한 처리를 할 수 있다.

<br>

## 14.3 HttpSecurity

- Spring Security를 사용하게 되면 여러 웹 프로젝트에서 간단하게 사용할 수 있는 기본 설정들을 제공한다.
- 실습을 통해 API 서버를 만들게 되고 Customizing된 설정을 사용해야 하므로 HttpSecurity를 Configuration해서 직접 Control할 예정이다.