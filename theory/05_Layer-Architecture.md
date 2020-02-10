# 05. Layer Architecture

## 5.1 이전까지의 Layer 구성

1. **UI Layer** (`interfaces` 패키지)
   - Controller
2. **Domain Layer** (`domain` 패키지)
   - Restaurant (model)
   - Repository

<br>

## 5.2 Application Layer 추가

- `application` 패키지 추가
- `Menu`, `Item` domain model 생성 
  - Application Layer의 필요성 확인
  - 위의 2가지 domain model이 추가되면서 코드는 좀 더 복잡한 로직을 갖게 된다.
  - 이것을 단순화하기 위해 application layer를 도입한다.
- Application Layer에는 `RestaurantService`라는 객체가 추가된다.
- 여기서 복잡한 로직들을 모아서 처리하게 된다.