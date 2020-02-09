# 03. REST API

- 웹, 모바일 등 여러 가지의 서비스 지원 필요
- 서로 다른 Front-end가 필요
- Back-end는 하나로 제공

## 3.1 REST

- **RE**presentational **S**tate **T**ransfer
- 표현 상태를 전달
- Resource를 처리하는 것을 의미

<br>

## 3.2 Resource를 처리하는 방식

- CRUD
  - Create $\rightarrow​$ POST
  - Read $\rightarrow$ GET
  - Update $\rightarrow$ PUT/PATCH
  - Delete $\rightarrow$ DELETE 

<br>

## 3.3 Resource 지정

1. **URI (Uniform Resource Identifier)**
   - Resource를 지정할 때 URI라는 식별자를 사용
2. **URL (Uniform Resource Locator)**
   - Resource를 지정할 떄 URL이라는 지시자를 사용

<br>

## 3.4 Resource의 분류

1. Collection
2. Member 

<br>

### 3.4.1 Collection

- Read(List)
- Create
- ex) `http://host/restaurant`

<br>

### 3.4.2 Member

- Read(Detail)
- Update
- Delete

- ex) `http://host/restaurant/1`
- ex) `http://host/restaurant/{id}`

<br>

## 3.5 JSON

- JavaScript Object Notation
- 결과를 받거나 정보를 넘길 때 JSON 포맷을 사용한다

```javascript
{
    "id": 2019,
    "name": "식당",
    "address": "골목"
}
```

```javascript
{
    {
        "id": 2001,
        "name": "오디세이",
        "address": "우주"        
    },
    {
        "id": 2019,
        "name": "식당",
        "address": "골목"        
    }        
}
```

<br>

## 3.6 APIs

### 3.6.1 가게 목록

- GET /restaurants 

<br>

### 3.6.2 가게 상세

- GET /restaurants/1
- GET /restaurants/{id}

<br>

### 3.6.3 가게 추가

- POST /restaurants

<br>

### 3.6.4 가게 수정

- PATCH /restaurants/{id}

<br>

### 3.6.5 가게 삭제

- DELETE /restaurants/{id}