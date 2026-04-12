# 📘 Today I Learned

### 1. 오늘 배운 내용

- 객체지향 역할 분리: 검증 로직을 main에 두는 방식(Step 1)과 클래스 내부로 옮기는 방식(Step 2)을 비교하며 '캡슐화'의 기초를 학습함.

- 접근 제어자 실습: public, default, private을 각각 선언하고, 타 패키지에서 접근했을 때 발생하는 컴파일 에러를 통해 데이터 보호 원리를 이해함.

### 2. 핵심 정리 
- src 폴더의 중요성: 자바 소스 코드는 반드시 src 폴더(Sources Root) 안에 있어야 인텔리제이가 '코드'로 인식하고 실행 버튼(▶️)을 띄워준다.

- main 메서드: 프로그램의 시작점. 클래스(설계도)는 가만히 있고, main에서 new 키워드로 객체를 찍어내야 비로소 프로그램이 살아 움직인다.

- 캡슐화와 접근 제어: 중요한 정보(generation)는 private으로 숨겨서 외부의 실수로부터 보호해야 한다. 외부와 소통할 때는 약속된 메서드(checkSelf, printInfo)를 통해서만 하는 것이 안전하다.

### 3. 결과 이미지

<img width="2784" height="950" alt="PBL 코드 실행 결과 1" src="https://github.com/user-attachments/assets/35e38c38-ef2a-49d3-b000-330d61c1e795" />
PBL 코드 실행 결과 1-1

<img width="2880" height="1170" alt="PBL 코드 실행 결과 2" src="https://github.com/user-attachments/assets/cc9ea582-80e8-4ca3-a035-a008e83057a9" />
PBL 코드 실행 결과 1-2

<img width="2880" height="1146" alt="PBL 코드 실행 결과 3" src="https://github.com/user-attachments/assets/ae26fd82-eeda-4837-82a8-1668368e574b" />
PBL 코드 실행 결과 2-1

<img width="2880" height="1146" alt="PBL 코드 실행 결과 4" src="https://github.com/user-attachments/assets/8522f512-946e-4d2f-96f8-a9313fd7791c" />
PBL 코드 실행 결과 2-2

<img width="2880" height="1142" alt="PBL 코드 실행 결과 5" src="https://github.com/user-attachments/assets/1abe9aee-36bc-4510-b38a-d90e800a9198" />
PBL 코드 실행 결과 3

### 4. 느낀 점

처음에는 인텔리제이 폴더 구조가 꼬여서 src 폴더나 main 메서드를 찾는 것부터 쉽지 않았다. 

하지만 하나씩 패키지를 만들고 클래스를 채워가면서, 왜 자바에서 폴더 구조와 접근 제어자가 중요한지 알 수 있었다. 

특히 private 변수 때문에 발생한 에러를 해결하고, 제안사항에 맞춰 코드를 다듬는 과정을 통해 데이터를 수동적으로 노출하지 않고 캡슐화를 이용해 스스로 보호하고 관리하는 자율적인 객체에 대해 배울 수 있었다.
