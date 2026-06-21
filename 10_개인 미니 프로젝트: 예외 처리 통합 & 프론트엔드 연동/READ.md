# 🦁 Likelion PBL10 Member & Assignment API

## 1. 프로젝트 소개

멤버와 과제를 관리하는 Spring Boot 기반 CRUD 프로젝트입니다.
Member와 Assignment의 등록, 조회, 수정, 삭제 기능을 제공하며, 전역 예외 처리와 커스텀 예외를 적용하여 에러 응답 형식을 통일했습니다.

또한 프론트엔드 정적 파일을 `src/main/resources/static`에 배치하여 브라우저 화면에서 직접 API 요청과 응답 흐름을 확인할 수 있습니다.


## 2. 기술 스택

| 구분         | 기술                                  |
| ---------- | ----------------------------------- |
| Language   | Java 17 이상                          |
| Framework  | Spring Boot 3.x                     |
| ORM        | Spring Data JPA                     |
| Database   | MySQL                               |
| Build Tool | Gradle                              |
| Frontend   | HTML, CSS, JavaScript               |
| API Test   | Swagger UI, Browser, HTTP Log Panel |



## 3. 주요 기능

### Member 기능

* 전체 멤버 조회
* 파트별 멤버 필터링
* 멤버 단건 조회
* LION 멤버 등록
* STAFF 멤버 등록
* 멤버 수정
* 멤버 삭제
* 중복 이름 등록 방지

### Assignment 기능

* 특정 멤버에게 과제 등록
* 전체 과제 조회
* 특정 멤버의 과제 조회
* 과제 단건 조회
* 과제 제목 검색
* 과제 수정
* 과제 삭제

### 예외 처리 기능

* 존재하지 않는 멤버 조회 시 404 응답
* 존재하지 않는 과제 조회 시 404 응답
* 중복된 멤버 이름 등록 시 409 응답
* 모든 에러 응답을 동일한 JSON 형식으로 반환



## 4. 실행 방법

### 4-1. 프로젝트 클론

```bash
git clone <repository-url>
cd PBL
```

### 4-2. MySQL 데이터베이스 생성

MySQL에서 아래 데이터베이스를 생성합니다.

```sql
CREATE DATABASE likelion_pbl;
```

### 4-3. application.properties 설정

`src/main/resources/application.properties` 파일에 데이터베이스 정보를 설정합니다.

```properties
spring.application.name=PBL10

spring.datasource.url=jdbc:mysql://localhost:3306/likelion_pbl?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=본인_DB_비밀번호
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

데이터를 유지하고 싶다면 아래처럼 변경 가능합니다.

```properties
spring.jpa.hibernate.ddl-auto=update
```

### 4-4. 애플리케이션 실행

Mac 또는 Linux에서는 다음 명령어를 사용합니다.

```bash
./gradlew bootRun
```

Windows에서는 다음 명령어를 사용할 수 있습니다.

```bash
.\gradlew bootRun
```

또는 IntelliJ에서 `PBL10Application.java`의 실행 버튼을 눌러 실행할 수 있습니다.

### 4-5. 브라우저 접속

애플리케이션 실행 후 아래 주소로 접속합니다.

```text
http://localhost:8080
```

Swagger UI를 사용하는 경우 아래 주소로 접속합니다.

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 5. API 목록

## Member API

| HTTP Method | URI                    | 설명          |
| ----------- | ---------------------- | ----------- |
| GET         | `/members`             | 전체 멤버 조회    |
| GET         | `/members?part={part}` | 파트별 멤버 필터링  |
| GET         | `/members/{id}`        | 멤버 단건 조회    |
| POST        | `/members/lions`       | LION 멤버 등록  |
| POST        | `/members/staffs`      | STAFF 멤버 등록 |
| PUT         | `/members/lions/{id}`  | LION 멤버 수정  |
| PUT         | `/members/staffs/{id}` | STAFF 멤버 수정 |
| DELETE      | `/members/{id}`        | 멤버 삭제       |

### LION 등록 요청 예시

```json
{
  "name": "홍길동",
  "major": "컴퓨터공학과",
  "generation": 12,
  "part": "백엔드",
  "studentId": "20231234"
}
```

### STAFF 등록 요청 예시

```json
{
  "name": "김운영",
  "major": "소프트웨어학과",
  "generation": 12,
  "part": "백엔드",
  "studentId": "20230001",
  "position": "회장"
}
```

---

## Assignment API

| HTTP Method | URI                                     | 설명            |
| ----------- | --------------------------------------- | ------------- |
| POST        | `/members/{memberId}/assignments`       | 특정 멤버에게 과제 등록 |
| GET         | `/assignments`                          | 전체 과제 조회      |
| GET         | `/members/{memberId}/assignments`       | 특정 멤버의 과제 조회  |
| GET         | `/assignments/{id}`                     | 과제 단건 조회      |
| GET         | `/assignments/search?keyword={keyword}` | 과제 제목 검색      |
| PUT         | `/assignments/{id}`                     | 과제 수정         |
| DELETE      | `/assignments/{id}`                     | 과제 삭제         |

### 과제 등록 요청 예시

```json
{
  "title": "전역 예외 처리 과제",
  "description": "커스텀 예외와 GlobalExceptionHandler를 구현한다."
}
```

---

## 6. 에러 응답 형식

모든 에러 상황에서는 동일한 형식의 JSON 응답을 반환합니다.

```json
{
  "status": 404,
  "message": "존재하지 않는 멤버입니다. id=9999"
}
```

### 에러 응답 예시

| 상황            | HTTP 상태 코드    | 응답 메시지            |
| ------------- | ------------- | ----------------- |
| 존재하지 않는 멤버 조회 | 404 Not Found | 존재하지 않는 멤버입니다.    |
| 존재하지 않는 과제 조회 | 404 Not Found | 존재하지 않는 과제입니다.    |
| 중복 이름으로 멤버 등록 | 409 Conflict  | 이미 존재하는 멤버 이름입니다. |

---

## 7. 프로젝트 구조

```text
src/main/java/com/likelion/
├── member/
│   ├── controller/
│   │   └── MemberController.java
│   ├── service/
│   │   └── MemberService.java
│   ├── repository/
│   │   └── MemberRepository.java
│   ├── domain/
│   │   ├── Member.java
│   │   └── RoleType.java
│   └── dto/
│       ├── LionCreateRequest.java
│       ├── LionUpdateRequest.java
│       ├── StaffCreateRequest.java
│       ├── StaffUpdateRequest.java
│       └── MemberResponse.java
│
├── assignment/
│   ├── controller/
│   │   └── AssignmentController.java
│   ├── service/
│   │   └── AssignmentService.java
│   ├── repository/
│   │   └── AssignmentRepository.java
│   ├── domain/
│   │   └── Assignment.java
│   └── dto/
│       ├── AssignmentCreateRequest.java
│       ├── AssignmentUpdateRequest.java
│       └── AssignmentResponse.java
│
└── global/
    ├── exception/
    │   ├── GlobalExceptionHandler.java
    │   ├── MemberNotFoundException.java
    │   ├── AssignmentNotFoundException.java
    │   └── DuplicateMemberException.java
    └── dto/
        └── ErrorResponse.java
```

---

## 8. 프론트엔드 구조

```text
src/main/resources/static/
├── index.html
├── css/
│   └── style.css
└── js/
    ├── member.js
    └── assignment.js
```

| 파일                 | 역할                                 |
| ------------------ | ---------------------------------- |
| `index.html`       | 전체 화면 구조, 탭 전환, HTTP 통신 로그, 토스트 알림 |
| `css/style.css`    | 화면 스타일                             |
| `js/member.js`     | Member API 호출 및 UI 로직              |
| `js/assignment.js` | Assignment API 호출 및 UI 로직          |

Spring Boot는 `src/main/resources/static` 폴더의 정적 파일을 자동으로 서빙하므로, 별도의 설정 없이 `http://localhost:8080`으로 접속하면 화면을 확인할 수 있습니다.

---

## 9. 전역 예외 처리 흐름

기존에는 Controller에서 `null`을 확인하고 직접 에러 응답을 만들었습니다.
리팩토링 후에는 Service에서 문제가 발생하면 커스텀 예외를 던지고, `GlobalExceptionHandler`가 이를 처리합니다.

```text
Controller
→ Service 호출
→ Service에서 예외 발생
→ GlobalExceptionHandler가 예외 처리
→ ErrorResponse JSON 반환
→ 프론트엔드 토스트 알림 표시
```

이를 통해 Controller는 정상 흐름만 담당하고, 에러 처리는 한 곳에서 일관되게 관리할 수 있습니다.

---

## 10. HTTP 메서드와 CRUD 대응

| CRUD   | 의미     | HTTP 메서드 |
| ------ | ------ | -------- |
| Create | 데이터 생성 | POST     |
| Read   | 데이터 조회 | GET      |
| Update | 데이터 수정 | PUT      |
| Delete | 데이터 삭제 | DELETE   |

---

## 11. 실행 확인 방법

애플리케이션 실행 후 브라우저에서 다음 기능을 확인합니다.

1. `http://localhost:8080` 접속
2. LION 멤버 등록
3. STAFF 멤버 등록
4. 전체 멤버 조회
5. 파트별 멤버 필터링
6. 멤버 수정
7. 멤버 삭제
8. 과제 등록
9. 전체 과제 조회
10. 과제 제목 검색
11. 존재하지 않는 ID 조회 시 에러 토스트 확인
12. 중복 이름 등록 시 409 에러 확인
