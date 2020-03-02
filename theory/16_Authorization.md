# 16. Authorization  (인가)

- Access Token을 이용해 사용자가 어떤 것을 쓸 수 있고 어떻게 활용이 되는 지에 대해 다루는 것이 인가(Authorication)이다.

<br>

## 16.1 Stateless

- 상태를 따로 관리하지 않는다.
- 보통 상태를 유지하게 위해 Session을 사용한다.
- 실습 프로젝트에서는 서버에서 따로 상태를 관리하지 않고 있다.
- 그렇기 때문에 요청을 받을 때 마다 AccessToken을 받아서 이를 이용해 사용자를 식별하고 거기에 대한 처리를 해준다.

<br>

## 16.2 AccessToken 전달 : Header

- Http에 있는 Header를 이용해 AccessToken을 전달한다.
- Header를 통해서 여러 가지 부가적인 정보를 전달할 수 있다.
- 이는 실제로 전달하는 데이터가 구별된다.
- Header에는 Key, Value 쌍으로 여러 가지 데이터를 전달할 수 있다.
- 여기서 우리가 활용할 Key가 바로 Authorization이다.
- 여기에 우리가 원하는 토큰 데이터를 넣어서 토큰을 계속해서 전달 받을 것이다.

<br>

## 16.3 Filter

- 요청을 받을 때마다 토큰을 받을 것이기 때문에 모든 요청에 대해서 토큰을 분석해서 사용자가 누구인 지 알아낼 필요가 있다.
- 이를 위해 Filter라는 것이 존재한다.
- Filter를 추가해 놓으면 모든 요청에 대해서 JWT 토큰이 실제로 세팅이 되어 있는 지 확인을 하고, AccessToken이 있다면 여기서 정보를 얻어서 사용자 아이디, 이름을 활용할 수 있다.

<br>

## 16.4 `BasicAuthenticationFilter`

- 위의 Filter 기능을 위해 Spring에서는 `BasicAuthenticationFilter` 를 제공한다.
- 이 것을 통해 계속해서 AccessToken을 분석할 수 있다.

<br>

## 16.5 `AuthenticationToken`

- Spring은 내부적으로 `AuthenticationToken` 객체를 활용해서 어떤 사용자가 사용중인 지를 확인한다.
- JWT를 분석해서 내부적으로 사용할 `AuthenticationToken`을 생성할 것이다.
- 이 것은 Spring 내부에서만 사용된다. (외부로 노출되는 AccessToken과 같은 것이 아님)

<br>

### 16.5.1 `UsernamePasswordAuthenticationToken`

- `AuthenticationToken` 의 가장 기본적인 형태 중 하나