📘 Today I Learned

1. 오늘 배운 내용
   
REST API 설계 원칙 학습: URI는 오직 자원(명사)으로만 표현하고, 자원에 대한 행위는 HTTP 메서드(POST, GET, PUT, DELETE)를 통해 제어하는 RESTful 아키텍처 규칙

역할 기반 DTO 분리: 공통 데이터 모델을 상속받는 Lion과 Staff의 특성에 맞춰 생성 및 수정 DTO를 각각 분리하여 설계하고, 성공/실패 여부에 따른 HTTP 상태 코드(201 Created, 200 OK, 204 No Content, 404 Not Found, 409 Conflict)를 ResponseEntity를 통해 동적으로 가공하는 컨트롤러 계층을 구현했다.

Spring Boot 패키지 구조화 및 포트 충돌 해결: 컴포넌트 스캔의 작동 원리를 파악하여 com.likelion과 같은 표준 하위 패키지 구조로 모든 소스코드를 정비했다. 

Swagger UI(API 클라이언트) 연동: springdoc-openapi 라이브러리를 의존성에 주입하여 무거운 클라이언트 툴 설치 없이 브라우저에서 웹 UI 환경을 통해 모든 API 엔드포인트를 호출하고 응답 상태를 검증하는 환경을 구축했다.

2. 핵심 정리 
   
POST(등록) / PUT(수정) 분리: 라이언과 스태프는 전공, 기수 등은 같아도 각각 '학번'과 '직책'이라는 완전히 다른 고유 데이터를 가지기 때문에 주소와 DTO를 분리해서 처리해야 데이터 꼬임이 없다.

식별자 변환: 데이터베이스가 없는 메모리 저장소(MemoryMemberRepository) 환경에서 숫자 ID 대신 유일한 이름(name)을 주소창 경로 변수(@PathVariable)로 사용했으며, 스트림의 anyMatch와 filter를 돌려서 데이터의 유무와 중복 여부를 1차 검증했다.

메인 클래스의 위치 규칙: @SpringBootApplication 엔진을 켜는 파일은 무조건 모든 패키지(controller, service 등)의 꼭대기(상위 폴더)에 패키지 선언(package com.likelion;)을 달고 누워있어야 스프링이 부품들을 빠짐없이 스캔해서 찾아낼 수 있다.

3. 결과 이미지(스크린샷)

<img width="1298" height="946" alt="Lion 등록 swagger" src="https://github.com/user-attachments/assets/e8fba328-8feb-4623-80e9-fbbec24d61c2" />
Lion 등록 swagger

<img width="1312" height="950" alt="Lion 수정 swagger" src="https://github.com/user-attachments/assets/df540afd-10ac-4cdc-bab4-78c0ec6c3e0b" />
Lion 수정 swagger

<img width="1304" height="958" alt="Staff 등록 swagger" src="https://github.com/user-attachments/assets/03ef0c28-14fb-4eae-b5f0-71d520dbd03c" />
Staff 등록 swagger

<img width="1304" height="938" alt="Staff 수정 swagger" src="https://github.com/user-attachments/assets/4b6a2e6b-ee9c-4711-b476-32d737c73ffb" />
Staff 수정 swagger

<img width="1308" height="952" alt="단일 멤버 조회 swagger" src="https://github.com/user-attachments/assets/118d2616-d2d4-4e37-a023-58a547729d76" />
단일 멤버 조회 swagger

<img width="1310" height="628" alt="멤버 삭제 swagger" src="https://github.com/user-attachments/assets/e5f80a45-7698-4351-ba3e-189cb15cd21e" />
멤버 삭제 swagger

<img width="1292" height="700" alt="없는 멤버 삭제 swagger" src="https://github.com/user-attachments/assets/d646b072-198b-451a-89e1-460a26994c60" />
없는 멤버 삭제 swagge

<img width="1308" height="684" alt="이름 중복 등록 시 swagger" src="https://github.com/user-attachments/assets/78e4b468-d83b-41b7-af0e-50894a7aefe4" />
이름 중복 등록 시 swagger

4. 느낀 점
   
처음에는 순수 자바 프로젝트 구조에서 스프링 코드를 타이핑하다 보니 빌드 도구(Gradle)의 부재, 롬복 어노테이션 미인식, 그리고 스프링 부트가 약속한 패키지 경로(src/main/java/패키지명) 구조를 지키지 않아서였다는 것을 하나씩 트러블슈팅하며 깨달았습니다.

특히 포트 충돌 에러가 났을 때 인프라적인 문제까지 직접 터미널 창을 열어 해결해 보고, 최종적으로 구현하고 싶었던 Swagger를 작동하는 것을 성공했습니다. 

이번 미션을 통해 REST API 계층과 DTO 설계 메커니즘을 확실하게 복습할 수 있었습니다.
