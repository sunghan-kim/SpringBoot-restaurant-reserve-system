# 09. Front-end

## 9.1 Front-end 관련 기술

### 9.1.1 HTML, CSS, JavaScript

<br>

### 9.1.2 Node.js

- 서버 사이드 자바스크립트 or 범용 자바스크립트 런타임
- 여러 가지 에코 시스템을 가지고 있다.

<br>

### 9.1.3 WebPack

<br>

### 9.1.4 CORS(Cross-Origin Resource Sharing)

- 프론트 엔드에 관한 부분은 별도의 웹서버를 띄워서 실행을 한다.
- 그렇게 되면 벡엔드 API 서버와 완전히 다른 주소로 인식하게 된다.
- 이럴 경우에는 CORS에 따라서 보안상의 이유로 서로 접근할 수 없게 된다.
- 이 부분을 Spring에서 `@SpringOrigin` Annotation을 통해 처리할 예정이다.

<br>

## 9.2 Node Project 생성

- Node Project를 생성할 디렉토리로 이동

<br>

### 9.2.1 `node`

- 터미널에서 아래 명령어 실행하면 자바스크립트를 실행할 수 있는 환경이 활성화 된다.

  ```
  node
  ```

- `Ctrl + c`를 누르면 활성화된 환경을 종료할 수 있다.

<br>

### 9.2.2 node 프로젝트 생성

- 다음 명령어를 통해 node 프로젝트를 생성할 수 있다.

  ```
  npm init
  ```

- `entry point` 부분에 아래 내용을 입력한다.

  ```
  src/index.js
  ```

- `test command` 부분에 아래 내용을 입력한다.

  ```
  jest
  ```

- 모든 작업을 완료하면 해당 디렉토리에 `package.json` 파일이 생성된 것을 확인할 수 있다.

<br>

### 9.2.3 `index.html` 파일 생성

<br>

## 9.3 WebPack 활용

- [WebPack 사이트](<https://webpack.js.org/>)

- WebPack은 리소스들을 번들링해주는 도구이다.
- [WebPack > Documentation > Configuration > DevServer](<https://webpack.js.org/configuration/dev-server/>)
  - 개발용 서버
  - 이것을 활용하면 빠르게 개발용 서버를 띄울 수 있다.
  - 몇 가지 설정 파일들을 만들어서 쓸 수 있다. (설정 파일이 없어도 가능하다)

<br>

### 9.3.1 node의 `npm` 이용 WebPack 의존성 설치

- 다음 명령어를 통해 WebPack의 의존성 설치

- 이를 통해 webpack devserver를 사용할 수 있게 된다.

  ```
  npm install --save-dev webpack webpacak-cli webpack-dev-server
  ```

  - `--save-dev` flag를 사용하면 의존성이 개발용으로만 설치된다.

- 설치가 완료되면 `package.json` 파일에 의존성이 추가된 것을 확인할 수 있다.

<br>

### 9.3.2 `package-lock.json`

- 그리고 `package-lock.json` 파일이 자동으로 생성된다.
- 해당 파일은 자동으로 관리되기 때문에 별도로 수정할 필요 없다.
- 하지만, git의 version control에는 포함이 되어야 한다.

<br>

### 9.3.3 `node_modules`

- 우리가 사용할 라이브러리가 설치된 폴더가 만들어진다. 
- 이 또한 직접 관리할 필요는 없다.

<br>

## 9.4 서버를 실행시키기 위한 스크립트 작성

- 서버를 실행시키기 위한 스크립트를 `package.json` 파일 안에 명령으로 추가할 수 있다.

- `--port` floag를 이용해 포트번호를 지정할 수도 있다.

  ```json
  "scripts": {
      "start": "webpack-dev-server --port 3000", // 추가
      "test": "jest"
  }
  ```

<br>

### 9.4.1 `src` 디렉토리 생성

- `src` 디렉토리를 생성하고 해당 디렉토리 안에 `index.js` 파일을 생성한다.
- 

### 9.4.2 서버 실행

- 다음 명령어를 통해 서버를 실행시킬 수 있다.

  ```
  npm start
  ```

- `http://localhost:3000` 으로 접속하면 `index.html` 의 내용을 확인할 수 있다.

<br>

## 9.5 CORS 문제 해결

### 9.5.1 웹 서버 실행

- 다음 2가지의 웹 서버가 실행된 상태에서 진행한다.

- `restaurant-reserve-system-api`
  - restaurant 관련 java 프로젝트가 올라가 있는 웹서버
  - `http://localhost:8080` 으로 접속 가능
- `restaurant-reserve-system-web`
  - `npm start`로 node 서버도 실행시킨 상태
  - `http://localhost:3000` 으로 접속 가능

<br>

#### 9.5.2 `fetch()` 이용 정보 요청

- `http://localhost:3000`에서 관리자 도구 실행

- `Console` 부분에 다음 코드 실행하여 해당 URL에 정보를 요청할 수 있다.

  ```javascript
  fetch('http://localhost:8080/restaurants')
  ```

- 해당 명령어를 실행하면 다음과 같은 에러 메세지가 출력된다.

  ```javascript
  Access to fetch at 'http://localhost:8080/restaurants' from origin 'http://localhost:3000' has been blocked by CORS policy
  ```

- CORS 이슈 때문에 해당 요청을 처리할 수 없다.

- 이 CORS 이슈는 Spring 설정으로 해결이 가능하다.

<br>

### 9.5.3 Spring 설정을 통한 CORS 이슈 해결

- `restaurant-reserve-system-api`에 있는 `RestaurantController.java`로 이동
- 해당 파일에 `@CrossOrigin` annotation을 추가하면 이 문제가 쉽게 해결된다.

<br>

### 9.5.4 결과 확인

- 다시 개발자 도구 `Console`에서 다음 코드를 실행하여 정보를 요청해본다.

  ```javascript
  fetch('http://localhost:8080/restaurants').then(r => r.json()).then(console.log)
  ```

- 해당 URL의 정보를 확인할 수 있다.

<br>

## 9.6 URL 요청을 통해 응답받은 데이터 출력

- `index.html`, `index.js` 파일 참고

