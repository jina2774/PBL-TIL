# 📘 Today I Learned

### 1. 오늘 배운 내용

순수 Java 코드의 Spring Boot 프로젝트 전환: 5주차에서 Main에 직접 new를 사용해 객체를 생성하고 조립했던 순수 자바 코드를 Spring Boot 환경으로 마이그레이션하는 과정을 배웠다.

수동 의존성 주입(수동 DI): @Configuration과 @Bean 어노테이션을 활용하여 스프링 설정 클래스 내에서 개발자가 직접 빈을 등록하고 객체 간의 의존 관계를 화살표로 엮어주는 방식을 경험했다.

자동 의존성 주입(자동 DI): 서비스와 레포지토리 구현체 클래스에 각각 @Service와 @Repository를 부여하고 컴포넌트 스캔과 @Autowired 메커니즘을 통해 어노테이션만으로 객체가 자동 조립되는 흐름을 배웠다.

REST API 컨트롤러 구현: @RestController와 @GetMapping을 사용하여 브라우저의 HTTP GET 요청을 스프링이 웹 컨트롤러 빈으로 처리하고 응답 데이터를 반환하는 구조를 파악했다.

### 2. 핵심 정리 

IoC란?: 내가 주도권을 쥐고 객체를 new로 직접 만들고 관리했었는데, 이제는 스프링 컨테이너에게 객체의 제어권과 조립의 주도권을 통째로 넘겨버린 현상을 뜻한다.

수동 주입 vs 자동 주입의 빈 등록 이름의 차이:

수동 주입을 할 때는 AppConfig 내부의 메서드 명(memberService, memberRepository)으로 빈 저장소에 박힌다.

반면 자동 주입(@Component 계열)으로 바꾸면, 스프링이 구현체 파일들을 스캔해가면서 클래스 명의 첫 글자만 소문자로 바꾼 이름(memberService, memoryMemberRepository)으로 빈을 자동 등록한다.

생성자가 1개일 때 @Autowired 생략: 클래스 안에 주입받을 생성자가 딱 1개만 있으면 굳이 @Autowired 글자를 써주지 않아도 부품 주입 경로가 하나뿐인 것을 인지해서 알아서 조립해 준다.

@RestController의 역할: 이 어노테이션이 붙은 클래스는 단순한 백엔드 로직용 객체가 아니라, 웹 브라우저가 보낸 주소를 알아듣고 텍스트나 데이터를 그대로 보내주는 컨트롤러가 된다.

### 3. 결과 이미지
<img width="2880" height="1800" alt="수동 주입 다이이그램 실행 결과" src="https://github.com/user-attachments/assets/f3902add-3ec9-492b-b33c-5e7511116d8b" />
수동 주입 다이이그램 실행 결과(Community 버전은 스프링 빈 다이어그램 지원x)

<img width="2880" height="1800" alt="자동 주입 다이이그램 실행 결과" src="https://github.com/user-attachments/assets/042a8bd5-2da3-4760-a79f-de19f91c1b65" />
자동 주입 다이이그램 실행 결과(Community 버전은 스프링 빈 다이어그램 지원x)

<img width="2880" height="1718" alt="브라우저 실행 결과" src="https://github.com/user-attachments/assets/e0a049d6-f3cb-4af6-9213-a7642f824e59" />
브라우저 실행 결과

### 4. 느낀 점

처음엔 스프링 이니셜라이저 사이트 설정부터 낯설었다.

5주차 때 저장소 객체가 꼬이지 않게 일일이 코드로 관리하던 것에서 벗어나, 클래스 위 @Service, @Repository 어노테이션 한 줄 추가로 스프링이 자동으로 객체를 연결해 주는 것을 경험하고 편리함을 느꼈다. 

개발자의 개입이 줄어들고 주요 코드에만 집중할 수 있게 해주는 기능을 배울 수 있었다.
