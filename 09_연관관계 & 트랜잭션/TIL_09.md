# 📘 Today I Learned: JPA 연관관계와 트랜잭션 실습

### 1. 오늘 배운 내용

JPA 연관관계 매핑: Assignment와 Member 사이의 1:N 관계를 @ManyToOne과 @OneToMany로 설계하는 법을 배웠다.

연관관계의 주인: 외래 키 member_id 를 관리하는 주체로서 N인 Assignment가 연관관계의 주인임을 이해하고, mappedBy를 통해 양방향 관계를 설정했다.

트랜잭션@Transactional: 서비스 계층에서 데이터 일관성을 보장하기 위해 트랜잭션을 적용했다.

readOnly = true 활용: 조회 메서드에는 읽기 전용 트랜잭션을 적용하여 불필요한 변경 감지(Dirty Checking)를 방지하고 성능을 최적화하는 방법을 배웠다.


### 2. 핵심 정리 

연관관계 매핑: DB에서는 외래 키 하나만 있으면 되지만, 자바 객체 세계에서는 양쪽 다 참조를 가질 수 있게 연결하는 작업이다.

이때 누가 외래 키를 관리할 것인지 결정하는 것이 가장 중요하며, 항상 'N' 쪽 엔티티가 주인이 된다.

mappedBy의 의미: 주인이 아니라고 선언하는 것이다. 

이를 통해 무분별한 외래 키 생성을 막고 객체 간 참조를 명확히 할 수 있다.

트랜잭션 전략: 서비스 클래스 전체에는 readOnly = true를 기본으로 깔아두고, 데이터를 추가하거나 수정하는 특정 메서드에만 @Transactional을 붙여서 안전성을 확보한다.


### 3. 결과 이미지

<img width="2114" height="1168" alt="과제 등록 Swagger" src="https://github.com/user-attachments/assets/35046e29-6fb8-4dca-b5d5-4d3969ac4aa1" />
과제 등록 Swagger

<img width="2106" height="982" alt="존재하지 않는 멤버에게 과제 등록 Swagger" src="https://github.com/user-attachments/assets/13330e5c-2abd-420e-aaa7-90cf67e458f8" />
존재하지 않는 멤버에게 과제 등록 Swagger

<img width="2094" height="1246" alt="멤버별 과제 목록 조회 Swagger" src="https://github.com/user-attachments/assets/293e19b7-45ae-4944-81a2-d86a32c9d250" />
멤버별 과제 목록 조회 Swagger

<img width="2538" height="1234" alt="과제 단건 조회 Swagger" src="https://github.com/user-attachments/assets/f86975c6-8ac6-4b44-b20f-a472b6b77d95" />
과제 단건 조회 Swagger

<img width="2106" height="1174" alt="과제 수정 Swagger" src="https://github.com/user-attachments/assets/5e65c0a4-4196-4597-9071-60ca75271960" />
과제 수정 Swagger

<img width="2088" height="792" alt="과제 삭제 Swagger" src="https://github.com/user-attachments/assets/34dee6bc-baab-426b-9b7e-b89a1d1eee76" />
과제 삭제 Swagger

<img width="2880" height="1800" alt="콘솔 SQL 출력 " src="https://github.com/user-attachments/assets/f0a8a722-f6e9-418a-84ba-cde235529646" />
콘솔 SQL 출력

<img width="2880" height="1800" alt="MySQL Workbench 확인 1" src="https://github.com/user-attachments/assets/e4921506-6f59-43a2-a89b-40a8faa282a2" />
MySQL Workbench 확인 1

<img width="2880" height="1800" alt="MySQL Workbench 확인 2" src="https://github.com/user-attachments/assets/0ec577f5-7989-46e6-9f18-9efb60a0d796" />
MySQL Workbench 확인 2

### 4. 느낀 점

그동안 단독으로 엔티티를 저장했었는데, 이번 주에 연관관계 매핑을 배우면서 실제 데이터들이 어떻게 엮이는지 배울수 있었다. 

특히 mappedBy를 설정할 때, DB와 객체 관점이 다르다는 것이 처음엔 헷갈렸지만, 주인 @ManyToOne과 읽기 전용 @OneToMany 개념을 잡고 나니 훨씬 알아보기 쉬워졌다. 
