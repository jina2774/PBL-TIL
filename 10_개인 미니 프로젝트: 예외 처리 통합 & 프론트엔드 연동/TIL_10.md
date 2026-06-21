# 📘 Today I Learned

### 1. 오늘 배운 내용

이번 실습에서는 Spring Boot 백엔드 API와 프론트엔드 화면이 HTTP 통신을 통해 어떻게 연결되는지 직접 확인했다. 

브라우저에서 멤버 등록, 수정, 삭제, 과제 조회, 과제 검색 기능을 실행하고, 화면 하단의 HTTP 통신 로그 패널을 통해 요청 메서드, 요청 URL, 상태 코드를 관찰했다.

#### 활동 1: 동작별 HTTP 메서드 관찰

| 화면 동작                | HTTP 메서드 | 요청 URL                              | 상태 코드 |
| -------------------- | -------- | ----------------------------------- | ----- |
| 페이지 최초 접속            | GET      | `/` 또는 `/index.html`                | 200   |
| 멤버 등록 (LION)         | POST     | `/members/lions`                    | 201   |
| 멤버 목록에서 "수정" 클릭 후 저장 | PUT      | `/members/lions/{id}`               | 200   |
| 멤버 목록에서 "삭제" 클릭      | DELETE   | `/members/{id}`                     | 204   |
| 과제 탭에서 "전체 조회" 클릭    | GET      | `/assignments`                      | 200   |
| 과제 제목 검색             | GET      | `/assignments/search?keyword={검색어}` | 200   |

조회 기능은 `GET` 메서드를 사용하고, 등록 기능은 `POST` 메서드를 사용한다. 

수정 기능은 기존 데이터를 변경하는 작업이므로 `PUT` 메서드를 사용하고, 삭제 기능은 데이터를 제거하는 작업이므로 `DELETE` 메서드를 사용한다.

| CRUD   | 의미     | HTTP 메서드 |
| ------ | ------ | -------- |
| Create | 데이터 생성 | POST     |
| Read   | 데이터 조회 | GET      |
| Update | 데이터 수정 | PUT      |
| Delete | 데이터 삭제 | DELETE   |

#### 활동 2: Request Body 추적

멤버를 등록할 때 프론트엔드는 JSON 형식의 데이터를 백엔드로 전송한다. 

<LION 멤버를 등록할 때 Request Body 필드 예시>

json
{
  "name": "홍길동",
  "major": "컴퓨터공학과",
  "generation": 12,
  "part": "백엔드",
  "studentId": "20231234"
}


이 필드들은 백엔드의 `LionCreateRequest` DTO 필드와 대응된다.

| JSON 필드      | 백엔드 DTO 필드                     |
| ------------ | ------------------------------ |
| `name`       | `LionCreateRequest.name`       |
| `major`      | `LionCreateRequest.major`      |
| `generation` | `LionCreateRequest.generation` |
| `part`       | `LionCreateRequest.part`       |
| `studentId`  | `LionCreateRequest.studentId`  |

과제를 등록할 때는 URL과 JSON Body에 들어가는 정보가 나뉜다.

<예시 요청 URL>

text
POST /members/{memberId}/assignments


<1번 멤버에게 과제를 등록한다면>

text
POST /members/1/assignments


<Request Body에는 과제의 제목과 설명이 들어간다>

```json
{
  "title": "예외 처리 과제",
  "description": "전역 예외 처리기를 구현한다."
}
```

URL에 포함된 `memberId`는 어떤 멤버에게 과제를 등록할지를 나타내는 식별자이다. 

JSON Body에 포함된 `title`, `description`은 새로 생성할 과제 자체의 데이터이다. 

URL은 대상을 식별하고, Body는 생성하거나 수정할 실제 데이터를 담는 역할을 한다.


#### 활동 3: 에러 응답 관찰

<존재하지 않는 ID로 과제를 단건 조회>

```text
GET /assignments/9999
```

존재하지 않는 과제이므로 상태 코드는 `404 Not Found`가 반환된다. 

응답 json
{
  "status": 404,
  "message": "존재하지 않는 과제입니다. id=9999"
}


화면 우측 상단에 표시되는 토스트 알림의 메시지는 응답 JSON의 `message` 필드에서 가져온다.

이미 등록된 이름과 동일한 이름으로 멤버를 다시 등록하면 상태 코드는 `409 Conflict`가 반환된다.

json
{
  "status": 409,
  "message": "이미 존재하는 멤버 이름입니다. name=홍길동"
}


존재하지 않는 과제를 조회할 때는 요청한 자원이 없기 때문에 `404 Not Found`가 발생한다. 

중복 이름으로 멤버를 등록할 때는 이미 존재하는 데이터와 충돌하기 때문에 `409 Conflict`가 발생한다.

<에러 응답>

text
Service에서 커스텀 예외 발생
→ GlobalExceptionHandler가 예외를 잡음
→ ErrorResponse 객체 생성
→ status와 message를 담은 JSON 응답 반환
→ 프론트엔드가 message 값을 토스트 알림으로 표시


예를 들어 존재하지 않는 과제를 조회하면 `AssignmentNotFoundException`이 발생하고, `GlobalExceptionHandler`에서 이를 처리하여 `ErrorResponse` 형태의 404 응답을 반환한다. 
중복 이름으로 멤버를 등록하면 `DuplicateMemberException`이 발생하고, 전역 예외 처리기가 409 응답을 반환한다.

### 2. 핵심 정리 

이번 실습을 통해 프론트엔드와 백엔드가 JSON을 주고받으며 통신하는 흐름을 이해했다. 

사용자가 화면에서 버튼을 누르면 JavaScript 코드가 실행되고, `fetch()`를 통해 Spring Controller로 HTTP 요청을 보낸다.

Controller는 요청을 받아 Service를 호출하고, Service는 비즈니스 로직을 처리한 뒤 결과를 DTO 형태로 반환한다.

기존에는 Controller에서 `null`을 직접 확인하고 에러 응답을 만들어야 했지만, 이번에는 Service에서 문제가 생기면 커스텀 예외를 던지고, `GlobalExceptionHandler`가 모든 예외를 한 곳에서 처리하도록 리팩토링했다.

그 결과 Controller는 정상 흐름만 담당하게 되었고, 에러 응답 형식도 `status`, `message`를 가진 JSON으로 통일되었다.

HTTP 메서드도 CRUD와 연결해서 이해할 수 있었다. 


### 3. 결과 이미지
<img width="1320" height="1148" alt="전체 과제 조회" src="https://github.com/user-attachments/assets/93b09aeb-c8e2-4a05-90d9-a0a7f2efe5d0" />
전체 과제 조회
<img width="1314" height="1136" alt="과제 제목 검색" src="https://github.com/user-attachments/assets/6799024e-5ab4-4b86-9cfe-314347f2694a" />
과제 제목 검색
<img width="1314" height="1214" alt="존재하지 않는 과제 수정" src="https://github.com/user-attachments/assets/39e149b5-f416-4ce5-b27c-62e0d00b1a26" />
존재하지 않는 과제 수정
<img width="1318" height="1118" alt="존재하지 않는 멤버 조회" src="https://github.com/user-attachments/assets/7c1b7c6d-686d-4621-b2b3-56f54e8e3537" />
존재하지 않는 멤버 조회
<img width="1318" height="1288" alt="중복 이름으로 멤버 등록" src="https://github.com/user-attachments/assets/b63d0c67-c6b5-4774-919e-b94754afcf1f" />
중복 이름으로 멤버 등록
<img width="1316" height="1230" alt="파트별 멤버 필터링" src="https://github.com/user-attachments/assets/d2a635ab-953e-4617-b75a-9c42292a288b" />
파트별 멤버 필터링
<img width="1352" height="1446" alt="멤버 등록(아기사자,운영진)" src="https://github.com/user-attachments/assets/8b805f75-938a-47e9-bd0a-e06aa6f36cde" />
멤버 등록(아기사자,운영진)
<img width="1350" height="1402" alt="멤버 수정,삭제" src="https://github.com/user-attachments/assets/615aed7e-fef2-4888-8b6b-cf8da43c852b" />
멤버 수정,삭제
<img width="1354" height="1434" alt="과제 등록" src="https://github.com/user-attachments/assets/c0de95c3-f6e1-4794-ba9e-d08a982c61f9" />
과제 등록
<img width="1376" height="800" alt="과제 제목 검색2" src="https://github.com/user-attachments/assets/b745a77c-efda-445b-8e48-0a1b7186226e" />
과제 제목 검색2
<img width="1350" height="1168" alt="과제 수정,삭제" src="https://github.com/user-attachments/assets/287b041b-0458-4c35-a0f5-fd0b4ee6b1ef" />
과제 수정,삭제
<img width="1356" height="1408" alt="과제 조회(전체,멤버별,단건)" src="https://github.com/user-attachments/assets/644da227-4727-4045-a753-6607f464f157" />
과제 조회(전체,멤버별,단건)

### 4. 느낀 점

이번 실습을 하면서 백엔드 API가 Swagger에서만 동작하는 것이 아니라, 실제 브라우저 화면과 연결되게 만드는 과정을 경험했다.

화면에서 버튼을 클릭하면 어떤 HTTP 요청이 발생하고, 백엔드가 어떤 JSON 응답을 반환하는지 로그 패널을 통해 바로 확인할 수 있어서 파트별 연결 흐름이 더 잘 이해되었다.

특히 Controller의 역할이 훨씬 단순해진다는 것을 느꼈다. 

Controller가 모든 에러 상황을 직접 처리하면 코드가 복잡해지고 중복이 많아지지만, `@RestControllerAdvice`와 `@ExceptionHandler`를 사용하면 에러 처리 로직을 한 곳에서 관리할 수 있었다. 
