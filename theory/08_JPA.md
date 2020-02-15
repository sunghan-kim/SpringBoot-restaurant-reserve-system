# 08. JPA

## 8.1 Persistence (영속화)

- 자바는 영속화에 대한 표준을 가지고 있다.
- 이것이 바로 JPA(Java Persistence API)이다.

<br>

## 8.2 JPA에서 중요한 부분

### 8.2.1 Hibernate

- JPA의 라이브러리 중 유명한 것
- 데이터 관리 라이브러리

<br>

### 8.2.2 `@Entity`

- Identifier로 구분이 되는 객체들을 Entity라고 부른다.
- 관계형 데이터베이스에서도 각 데이터를 구분하는 데 Entity 단위를 사용한다.

<br>

## 8.3 Spring Data JPA

- JPA를 사용하는 데 있어서 JPA와 그 구현체인 Hibernate를 쓰는 데 있어서 복잡한 설정들이 많다.
- Spring Data JPA를 사용하여 이를 손쉽게 할 수 있다

<br>

## 8.4 H2 Database

- 실제로 사용하는 데이터베이스는 MySQL, MariaDB, Oracle, PostgreSQL, MS-SQL 등 이다.
- 이들 중 가장 간단한 것 중 하나인 H2 Database를 사용하여 실습을 진행한다.
- H2 Database는 여러  가지 저장하는 환경을 제공한다.
- 그 중 "In-memory" 방식을 사용한다.
- H2 Databse는 몇 가지 설정만을 통해 메모리에서 파일로 저장하는 곳을 바꿀 수 있다.

<br>



