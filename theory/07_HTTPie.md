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

  