# 06. Mock Object (가짜 객체)

## 6.1 Mock Object

- Controller Test를 만들면서 테스트 하고자 하는 것 외에 여러 개의 객체가 동시에 주입되는 것을 봤다.
- 이럴 경우, 테스트하고자 하는 대상 외의 객체들에 대한 의존성이 너무 커서 테스트에 집중하기 어렵다.
- 또한, 하나의 테스트를 통과시키기 위해서 의존하고 있는 부분들도 모두 만들어 줬어야 했다.
- 이럴 때 사용하는 것이 바로 **Mock Object, 가짜 객체**이다.

<br>

## 6.2 Mockito

- Mock Object를 만드는 다양한 방법이 존재한다.
- Spring은 **Mockito**라고 하는 Mock Object Framework를 사용하고 있다.
- 그러므로 별도의 설정 필요 없이 손쉽게 가짜 객체를 만들어서 활용할 수 있다.

<br>

## 6.3 POJO (Plain Old Java Object; 전통적인 자바 객체)

- Spring은 기본적으로 전통적인 자바 객체, 즉 POJO를 사용하는 것을 권장하고 지원한다.
- 그래서 Mockito와 같은 Mock Object Library를 지원하는 것이다.

