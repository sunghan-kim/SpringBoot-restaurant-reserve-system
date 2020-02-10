# 04. Dependency Injection(DI); 의존성 주입

## 4.1 Dependency; 의존성

- 의존 관계(둘 이상의 객체가 서로 협력하는 관계)를 의미한다.
- ex) A가 B에 의존한다.
  - A가 B를 사용한다.
  - B의 변화가 A에 영향을 준다. (A가 B를 사용하기 때문)
- ex) `Controller`는 `Repository`에 의존한다.

<br>

## 4.2 Spring IoC Container

- **객체를 만들어주고 연결해주는 작업**을 수행한다.
- DI는 위와 같은 객체간의 의존 관계를 Spring이 직접 관리하는 것을 의미한다.

- 주요 Annotation
  - `@Component`
  - `@Autowired`
  - `@SpyBean` (SpringBoot Annotation)

<br>

## 4.3 DI의 장점

- 우리가 사용해야 될 객체를 다양하게 변경할 수 있다.

<br>

## 4.4 여러 객체 관리

- 같은 방식으로 작동하는 여러 객체를 관리하려면 어떻게 해야 할까?
- Repository를 Interface로 변경하여 구체적인 구현체로 바꾼다.

- 인텔리제이에서 `우클릭 > Refactor > Extract > Interface` 선택
  - 내보낼 메서드를 선택하여 인터페이스를 생성할 수 있다.
- Repository를 사용하는 부분도 구현체를 직접 사용하는 것이 아닌 Interface를 사용하는 것으로 변경된 것을 볼 수 있다.
- 인터페이스화 했을 때엔 `@SpyBean`을 지정한 필드에 대해선 어떤 구현을 사용할 것인 지를 알려줘야 한다.
  - `@SpyBean(RestaurantRepositoryImpl.class)`
- 이를 통해 `@SpyBean`에 다양한 종류의 Repository 구현체를 지정함으로써 여러 가지 종류의 Repository를 사용하여 테스트를 할 수 있다.
- 기존에 Controller가 Repository에 직접적으로 의존하고 있던 것을 의존성 주입을 통해 의존성을 분리할 수 있었다.