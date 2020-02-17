# 07. HTTPie

## 7.1 HTTPie란?

- POST 작업을 확인하는 데 사용
- 브라우저에 주소를 입력하면 모두 GET으로만 요청하게 된다.
- 그래서 흔히 하는 것이 `form`을 만들어서 수행하거나 하는데, HTTPie를 이용하여 간단하게 결과를 확인할 수 있다.
- [HTTPie](<https://httpie.org/>)

<br>

## 7.2 HTTPie 설치 (Windows)

- 윈도우에서는 파이썬 `pip`를 통해 HTTPie를 설치할 수 있다.

  ```
  pip install -U httpie
  ```

<br>

## 7.3 HTTPie 사용

- 아래와 같은 명령어로 HTTPie를 사용할 수 있다.

  ```
  http GET[POST] URL
  ```

  ```
  http GET https://www.naver.com
  ```


<br>

## 7.4 HTTPie 주요 명령어

### 7.4.1 레스토랑 목록 조회

```
http GET localhost:8080/restaurants
```

<br>

### 7.4.2 레스토랑 상세 조회

```
http GET localhost:8080/restaurants/1
```

<br>

### 7.4.3 레스토랑 등록

```
http POST localhost:8080/restaurants name="Bob zip" address="Seoul"
```

<br>

### 7.4.4 레스토랑 수정

```
http PATCH localhost:8080/restaurants/1 name="Sool zip" address="Busan"
```

<br>

### 7.4.5 메뉴 추가, 수정, 삭제

```
http PATCH localhost:8080/restaurants/1/menuitems < menuitems.json
```

- json 파일 형태로 되어 있는 메뉴 추가

<br>

