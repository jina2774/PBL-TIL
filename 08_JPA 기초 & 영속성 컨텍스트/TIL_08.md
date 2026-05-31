
# 📘 Today I Learned: Spring Boot JPA & MySQL 연동

### 1. 오늘 배운 내용

- JPA와 RDBMS 연동: 메모리 저장소를 벗어나 MySQL 데이터베이스를 연동하고, `spring.jpa.hibernate.ddl-auto=create` 설정을 통해 엔티티를 자동으로 테이블화하는 과정을 학습했다.
  
- JpaRepository 활용: `JpaRepository<Member, Long>`을 상속받아 기본적인 CRUD를 자동화하고, 메서드 이름 규칙(`findByName`)을 통해 쿼리를 생성하는 방법을 익혔다.
  
- REST API 리팩토링: 7주차의 이름 기반 API를 고유 ID(Primary Key) 기반으로 전환하고, 응답 DTO를 통합하여 API 인터페이스를 표준화했다.
  
- 환경 설정: `application.properties`를 활용한 데이터베이스 연결 설정과 로깅 설정(Show SQL)을 수행했다.

### 2. 핵심 정리 

Spring Data JPA의 편리함: `new`를 통해 객체를 수동으로 생성하고 리스트에 담던 방식에서 벗어나, `save()`, `findById()`, `deleteById()`와 같은 표준화된 메서드만으로 DB와 소통할 수 있어 코드의 복잡도가 줄어들었다.
  
DTO 통합의 이유: 엔티티 구조가 단일화되었으므로, 응답 DTO 역시 `MemberResponse`로 통합하는 것이 코드 중복 방지와 프론트엔드 연동 측면에서 효율적이라고 느꼈다.

요청 DTO는 각 API의 목적이 명확하도록 역할별로 분리하는 것이 유지보수하기 좋을 것 같다.

엔티티 설계: `@Entity`, `@Id`, `@GeneratedValue` 등을 사용하여 클래스를 데이터베이스 테이블과 매핑하는 방법을 이해했고, 특히 `Enum` 타입을 `@Enumerated(EnumType.STRING)`으로 매핑하여 역할(Lion/Staff)을 DB에 문자열로 안전하게 저장하는 법을 배웠다.

### 3. 결과 이미지(스크린샷)

<img width="2238" height="1376" alt="Lion(아기사자) 등록 Swagger" src="https://github.com/user-attachments/assets/85868b0f-8b62-4f7a-9c22-96723343bf73" />
Lion(아기사자) 등록 Swagger

<img width="2226" height="1352" alt="Staff(운영진) 등록 Swagger" src="https://github.com/user-attachments/assets/46930884-511f-4487-a754-3162ac0ddcf8" />
Staff(운영진) 등록 Swagger

<img width="2238" height="1344" alt="Lion 수정 Swagger" src="https://github.com/user-attachments/assets/c7516917-83e6-465e-bc5e-fd4bf1becb09" />
Lion 수정 Swagger

<img width="2234" height="1192" alt="ID로 단일 멤버 조회 Swagger" src="https://github.com/user-attachments/assets/c4eea574-419b-46d8-a73f-ca57cdaaf043" />
ID로 단일 멤버 조회 Swagger

<img width="2256" height="664" alt="멤버 삭제 Swagger" src="https://github.com/user-attachments/assets/aa174706-8754-43c7-aadf-ff66027a0bbb" />
멤버 삭제 Swagger

<img width="2878" height="1800" alt="콘솔 SQL 출력" src="https://github.com/user-attachments/assets/e08ce158-c97c-4f7e-a83c-c06e030c034a" />
콘솔 SQL 출력

<img width="2880" height="1800" alt="MySQL Workbench 결과" src="https://github.com/user-attachments/assets/e3db9e10-3531-45ae-bfd7-df942a2be830" />
MySQL Workbench 결과


### 4. 느낀 점

기존의 로직을 고유 ID 기반의 REST API로 전환하는 과정에서 API 설계 원칙의 중요성을 체감했다. 

응답 DTO를 통합하고 엔티티와 DB를 매핑하면서 ResponseEntity로 상태 코드를 제어하는 부분이 특히 중요하다고 느꼈다.


