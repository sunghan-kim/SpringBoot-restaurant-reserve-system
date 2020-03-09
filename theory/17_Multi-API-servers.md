# 17. Multi API Servers

- 여러개의 API 서버를 동시에 사용해야 하는 상황이다.
- Front-end 도 함께 띄울 필요가 있다.
- DB 또한 h2 database의 file을 사용했기 때문에 동시에 여러 API 서버를 띄울 수 없었다.
- 그래서 h2 database를 MySQL로 변경할 필요가 있다.
- 이 모든 것을 가능하게 하는 것이 **Container** 기술이다.

<br>

## 17.1 Container

- 하나의 컴퓨터 안에서 가상화된 여러 개의 container를 올려서 여러 개의 서버를 동시에 실행하고 활용할 수 있게 해주는 기술이다.

- container 기술을 활용할 수 있는 것 중에 가장 유명한 것이 **Docker**이다.
- Docker Compose를 이용해서 여러 container들을 복잡한 작업 없이 한꺼번에 띄우고 활용할 수 있다.

<br>

## 17.2 Docker

- [Docker 홈페이지](https://docker.com)
- [Docker > Product > Desktop](<https://www.docker.com/products/docker-desktop>)
- Docker Desktop for Windows 다운로드

- 윈도우 10 home Docker 설치 참고 블로그
  - [https://gwonsungjun.github.io/articles/2018-01/DockerInstall](https://gwonsungjun.github.io/articles/2018-01/DockerInstall)
  - [https://luckygg.tistory.com/165](https://luckygg.tistory.com/165)

<br>

### 17.2.1 Docker 주요 명령어

```
docker ps
```

- docker 프로세스 확인

<br>

```
docker run -it --rm hello-world
```

- `-it` : 입력한 것과 출력 결과를 모두 볼 수 있다.
- `--rm` : 컨테이너를 실행했다가 나올 때 컨테이너를 완벽하게 삭제해준다.
- `hello-world` : docker에서 기본적으로 제공하는 이미지 이름

<br>

```
docker pull busybox
```

- `busybox` 이미지 다운로드

<br>

```dock
docker run -it busybox
```

- `busybox` 컨테이너 실행

<br>

```
exit
```

- docker container 실행 중인 상태에서 해당 컨테이너 종료

<br>

```
docker ps -a
```

- 이전에 실행했던 컨테이너 목록도 함께 보여줌

<br>

```
docker-compose up
```

- docker-compose 실행

<br>

```
docker-compose ps
```

- docker-compose 프로세스 확인

<br>

```
docker-compose logs admin-api
```

- admin-api의 로그 확인
- `-f` 옵션을 넣어주면 로그 파일이 갱신되는 내용을 확인할 수 있다.
  (`docker-compsoe logs -f admin-api`)

<br>



<br>



## 17.3 Jar 파일 생성

```
gradlew.bat bootJar
```

- 위 명령어를 통해 jar 파일을 생성할 수 있다.