# 11. Gradle

## 11.1 gradlew.bat

- 윈도우에서 gradle 명령을 실행할 수 있는 파일
- 터미널에서 프로젝트 경로에서 다음과 같은 gradle 명령어를 사용할 수 있다.

<br>

### 11.1.1 gradle build

```
gradlew.bat build
```

- build 명령어를 실행하기 전에 `common` 모듈의 `build.gradle` 파일에 다음 내용을 넣어줘야 build 명령어가 실행 가능하다.

  ```
  jar {
      enabled = true
  }
  
  bootJar {
      enabled = false
  }
  ```

- 해당 명령어를 통해 프로젝트에 포함되어 있는 모든 모듈들을 한꺼번에 build 할 수 있다.
- 테스트까지 같이 실행된 것을 확인할 수 있다.

<br>

### 11.1.2 gradle assemble

```
gradlew.bat assemble
```

- assemble 명령을 통해 jar 파일을 만들 수 있다.

<br>

### 11.1.3 gradle test

```
gradlew.bat test
```

- 컴파일 등의 작업이 수행된다.

<br>

### 11.1.4 gradle check

```
gradlew.bat check
```

<br>

## 11.2 인텔리제이에서 gradle 사용

- Edit Configuration 에서 위와 동일한 기능을 설정하여 사용할 수 있다.

<br>

- Edit Configuration에서 New Configuration으로 gradle 추가
- Name 지정
- Configuration > Gradle Project
  - 모든 모듈을 포함하고 있는 상위 프로젝트 선택
- Tasks
  - 11.1 에서 사용한 여러 가지의 gradle 명령어 지정 가능
  - 여기서는 `test` 입력
  - `clean test`
    - `clean`을 먼저 수행하고 `test`를 수행할 수 있다.

<br>

## 11.3 UP-TO-DATE

- test 를 실시했을 때, 콘솔에서 `UP-TO-DATE`라는 게 표시되는 것은 이미 실행된 부분들을 의미한다.
- 이미 실행된 것들은 아무 일도 일어나지 않고 지나치게 된다.

<br>

## 11.4 일반적인 테스트 시의 gradle 사용 설정

- Settings 로 이동
- Build, Execution, Deployment > Build Tools > Gradle 로 이동
- "Build and run using" 과 "Run test using"부분을 "IntelliJ IDEA"에서 "Gradle"로 변경
- 이렇게 하면 기본적으로 Junit으로 테스트가 진행되던 것이 Gradle로 변경된다.