📘 Today I Learned

1. 오늘 배운 내용

자바 객체지향 설계: 추상 클래스(Role)와 인터페이스(SubmissionPolicy)를 활용해 아기사자와 운영진의 공통점과 차이점을 분리하여 설계하는 법을 익혔다.

자료구조의 활용: ArrayList를 사용한 순차적 데이터 관리와 HashMap을 사용한 키-값(파트명-멤버목록) 기반의 효율적인 그룹화 방식을 배웠다.

인텔리제이 환경 설정: Sources Root 설정 문제로 발생하는 ClassNotFoundException의 원인을 파악하고, 프로젝트 구조를 재설정하여 해결하는 과정을 배웠다.

입력 버퍼 제어: Scanner.nextInt() 사용 후 발생하는 엔터 버퍼 문제를 nextLine()으로 처리하여 입력 꼬임 현상을 해결했다.


2. 핵심 정리 

클래스 이름이 같더라도 패키지(package1, package2)가 다르면 자바는 이를 완전히 다른 파일로 인식하며, 이를 통해 기능별로 코드를 안전하게 격리할 수 있다.

리스트에 나열하는 것 뿐만 아니라, 파트별로 멤버를 묶어 관리할 때 Map<String, List<Role>>을 사용하면 검색 속도와 관리 효율이 좋아진다.

사용자로부터 데이터를 입력받을 때 리스트를 순회하며 기존 데이터와 비교하는 로직을 통해 데이터의 무결성을 유지해야한다.

3. 결과 이미지

<img width="2880" height="1800" alt="PBL 코드 실행 결과1" src="https://github.com/user-attachments/assets/6e741211-b171-4a40-a6e5-da40c46d96d5" />
PBL 코드 실행 결과 1

<img width="2864" height="1800" alt="PBL 코드 실행 결과2" src="https://github.com/user-attachments/assets/1249a04f-c6fa-4f55-a155-728ff28fdb91" />
PBL 코드 실행 결과 2

<img width="2880" height="1800" alt="PBL 코드 실행 결과3" src="https://github.com/user-attachments/assets/0e568aad-02a0-4777-9ed1-8030e2a0a0c2" />
PBL 코드 실행 결과 3

<img width="2880" height="1800" alt="PBL 코드 실행 결과4" src="https://github.com/user-attachments/assets/fd487c12-f539-4917-bf09-810ae68d71b1" />
PBL 코드 실행 결과 4


5. 느낀 점

처음에는 인텔리제이 설정 오류 때문에 코드에는 문제가 없는데도 실행이 안 되어 많이 당황하고 답답했다.

하지만 여러번의 시도 끝에 개발 환경을 세팅 하는 것에 익숙해졌다.

복잡하게 느껴졌던 상속과 다형성을 실제 멤버 관리 시스템에 적용해 보니, 왜 인터페이스를 쓰는지와 코드 재사용의 장점을 확실하게 느낄 수 있었다. 

특히 Map을 활용해 파트별로 리스트를 생성하고 관리하는 로직을 직접 구현해 보면서 자바 자료구조를 다루는 것에 좀 더 친숙해진 것 같다.
