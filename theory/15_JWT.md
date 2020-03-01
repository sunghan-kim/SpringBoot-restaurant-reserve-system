# 15. JWT

- JSON Web Tokens
- JSON 포맷을 이용해서 웹에서 활용할 수 있는 Access Token을 다루는 표준

<br>

## 15.1 JSON 토큰의 구성

- JSON 토큰은 3개의 부분으로 구성되어 있다.
  - Header
  - Payload
  - Signature
- 각 부분에 일정한 데이터가 들어 있어서 이를 활용하여 더 나은 서비스를 제공할 수 있다.

<br>

### 15.1.1 Header

- 어떤 타입인지에 대한 정보가 들어 있음
- 어떤 알고리즘을 가지고 있는 지에 대한 정보가 들어 있음

<br>

### 15.1.2 Payload

- 실제로 어떤 데이터가 담겨 있는 지를 다룸
- Payload에 담긴 데이터는 암호화가 되지 않기 때문에 웹으로 노출하면 안 되는 데이터를 이 부분에 담아서는 안된다.

<br>

### 15.1.3 Signature

- 데이터 및 토큰이 위변조되지 않았음을 증명하는 서명이 담겨 있음

<br>

## 15.2 Base64 URL Encoding

- 위 3가지 부분은 `.`을 이용해 연결되어 있다.

  ```
  Header.Payload.Signature	
  ```

- 이 데이터는 JSON 포맷으로 되어 있지만 실제로 JSON 포맷으로 제공되면 안 되기 때문에 Base64 URL Encoding이라는 방법을 이용해서 JSON 데이터를 일정한 문자열로 바꿔준다.

- 그리고 그들이 전부 마침표(`.`)로 연결되어 하나의 문자열이 된다.

- 그리고 이것을 access token으로 활용하게 된다.

<br>

## 15.3 Claims

- Payload에 담기는 데이터는 Claim이라고 부른다.
- 이것들이 여러 개 들어가기 때문에 Claims이라고 한다.
- 여기에는 우리가 실제로 사용하게 될 것들(userId, userName, email 등)이 담긴다.
- 가능하면 Claims에 많은 데이터를 담지 않는 것이 좋다.

<br>

- Claims에 표준으로 제공하는 몇 가지 정보들이 있다.
  - 해당 토큰이 유효한 기간

<br>

## 15.4 HMAC-SHA256

- Signature에서 데이터가 위변조되지 않았음을 증명하기 위해서 서명을 하게 된다.
- 이 서명된 데이터는 데이터를 일정하게 해싱을 하고, 해싱된 데이터를 암호화하여 그 값이 나중에 검증을 했을 때 바뀌지 않았음을 증명하는 방식으로 활용하게 된다.
- 여기서는 HMAC-SHA256 방법을 활용한다.
- 이를 줄여서 HS256이라고도 한다.

<br>

### 15.4.1 비밀키 관리

- 서명을 할 때 비밀키를 활용하게 된다.
- 이 비밀키는 임의로 정해놔야 하고 이 것이 노출되면 다른 사람들이 서비스에서 만들어내고 있는 토큰을 똑같이 만들 수 있다. (즉, 위변조가 가능하다.)
- 그렇기 때문에 비밀키는 노출되지 않도록 잘 관리해야 한다.

<br>

## 15.5 JWT 웹사이트

- [https://jwt.io/](https://jwt.io/)

<br>

## 15.6 Java Token Signing/Verification Library

- `maven: io.jsonwebtoken / jjwt / 0.9.0` 가 가장 많이 사용된다.
- [jjwt repository](<https://github.com/jwtk/jjwt>)

<br>

## 15.7 JSON webtoken 사이트

- [https://www.jsonwebtoken.io/](https://www.jsonwebtoken.io/)

<br>

### 15.7.1 JWTK/JJWT

- Encode

  ```java
  import io.jsonwebtoken.Jwts;
  import io.jsonwebtoken.SignatureAlgorithm;
  import io.jsonwebtoken.impl.crypto.MacProvider;
  
  String s = Jwts.builder()
  	.setSubject("1234567890")
  	.setId("e5c62475-143e-46d9-be77-a6bb03b3b016")
  	.setIssuedAt(Date.from(Instant.ofEpochSecond(1583063756)))
  	.setExpiration(Date.from(Instant.ofEpochSecond(1583067356)))
  	.claim("name", "John Doe")
  	.claim("admin", true)
  	.signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"))
  	.compact();
  ```

- Decode

  ```java
  import io.jsonwebtoken.Jwts;
  import io.jsonwebtoken.SignatureAlgorithm;
  import io.jsonwebtoken.impl.crypto.MacProvider;
  import java.security.Key;
  
  try {
  
      Jwts.parser()
  	.setSigningKey("secret".getBytes("UTF-8"))
  	.parseClaimsJws("
  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImp0aSI6ImU1YzYyNDc1LTE0M2UtNDZkOS1iZTc3LWE2YmIwM2IzYjAxNiIsImlhdCI6MTU4MzA2Mzc1NiwiZXhwIjoxNTgzMDY3MzU2fQ.vJlZEgf_La9bAp1lHiJIzmEWZyn821LykuJLD8d5zOo
  	");
  
  
      //OK, we can trust this JWT
  
  } catch (SignatureException e) {
  
      //don't trust the JWT!
  }
  ```

  

