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
- 같은 방식으로 작동하는 여러 객체를 관리하려면 어떻게 해야 할까?
  - Repository를 Interface로 변경하여 구체적인 구현체로 바꾼다.
  - 
  - 