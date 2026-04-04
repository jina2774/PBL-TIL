📘 Today I Learned
1. 오늘 배운 내용
자바 콘솔 입력과 출력: Scanner 객체로 사용자 데이터를 입력받고, System.out.println을 활용해 결과물을 출력
예외 처리와 버퍼 관리: nextInt() 후 남는 개행 문자를 sc.nextLine()으로 비워주는 법과 InputMismatchException으로 숫자 외 입력을 제어하는 법
중복 검사 로직: 배열을 순회하며 equals() 메서드를 통해 데이터의 동일 여부를 판단하는 논리 구현
제어문 활용: while(true) 무한 루프와 break를 이용한 흐름 제어, for문을 이용한 배열 관리

2. 핵심 정리 
스캐너 청소 필수: 숫자를 받은 뒤(nextInt) 바로 문자열을 받으면 엔터값이 입력으로 들어갈 수 있으므로, sc.nextLine()으로 버퍼를 꼭 비워줘야 함
배열의 한계와 활용: 배열은 처음에 크기를 정하면 바꿀 수 없으므로, 사용자에게 먼저 인원수를 입력받아 유동적으로 크기를 지정하는 것이 효율적
반복문의 역할 분담: 전체 프로그램 유지에는 while, 정해진 횟수만큼 명단을 돌릴 때는 for를 쓰는 것이 가독성에 좋음

3. 결과 이미지
<img width="2880" height="1800" alt="PBL 코드 1" src="https://github.com/user-attachments/assets/a5e1dc09-f9d5-4994-b102-de166f9c84ae" />
<img width="2880" height="1800" alt="PBL 코드 2" src="https://github.com/user-attachments/assets/7ac5b12d-21cd-4aa4-9da9-133b949fd973" />
<img width="2880" height="1800" alt="PBL 코드 3" src="https://github.com/user-attachments/assets/9ec48c7d-2162-4500-b7fc-47e043bf2a44" />
<img width="2880" height="1800" alt="PBL 코드 실행 결과" src="https://github.com/user-attachments/assets/5857aaea-523d-445d-ae91-4d610bcba4c8" />
<img width="2880" height="1800" alt="PBL 보너스 코드 실행 결과 1" src="https://github.com/user-attachments/assets/abc2787c-1a47-4b7b-8095-5b4d64cf3207" />
<img width="2880" height="1800" alt="PBL 보너스 코드 실행 결과 2" src="https://github.com/user-attachments/assets/d0367365-aa9d-4c68-bd38-188f68a35916" />
<img width="2880" height="1800" alt="PBL 보너스 코드 실행 결과 3" src="https://github.com/user-attachments/assets/407e4c40-65f0-4cfc-a37a-06bb1191054d" />


4. 느낀 점
코드를 작성할 때 기능 구현에만 집중하는 것이 아니라, 사용자가 잘못 입력했을 때를 대비한 예외 처리의 중요성을 체감했다.
코드를 작성하며 git을 통해 파일을 관리하고 정리하는 과정을 반복해보니 헷갈렸던 git 사용법을 조금 더 익힐 수 있었다.
오랜만에 공부하는 java라서 문법을 많이 잊고 있었는데 다시 복습할 기회가 생겨 좋았다.
