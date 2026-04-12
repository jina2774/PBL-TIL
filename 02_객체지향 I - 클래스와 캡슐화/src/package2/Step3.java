package package2; // 패키지가 다릅니다!

import package1.Lion; // 다른 패키지의 클래스를 가져옵니다.

public class Step3 {
    public static void main(String[] args) {
        // 1. 객체 생성 및 초기 정보 출력
        System.out.println("🦁 아기사자 객체를 생성합니다.");
        Lion lion = new Lion("김멋대", "컴퓨터공학과", 14);

        System.out.println("🦁 아기사자 정보를 출력합니다.");
        lion.printInfo();
        System.out.println();

        // 2. public 필드 접근 시도
        System.out.println("📌 Step 3-1. public 필드 접근을 시도합니다.");
        System.out.println("👉 name 필드 값을 변경합니다.");
        lion.name = "홍길동"; // 가능!
        System.out.println("✅ public 필드 접근 성공");

        System.out.println("🦁 아기사자 정보를 출력합니다.");
        lion.printInfo();
        System.out.println();

        /* * 아래 코드들은 이미지 예시처럼 에러가 발생해야 합니다.
         * 확인 후 과제 제출 시에는 주석 처리를 하거나 에러 메시지를 기록하세요.
         */

        // 3. default 필드 접근 시도 (major)
        // lion.major = "소프트웨어학부";
        // 에러 메시지: 'major' is not public in 'package1.Lion'; cannot be accessed from outside package

        // 4. private 필드 접근 시도 (generation)
        // lion.generation = 15;
        // 에러 메시지: 'generation' has private access in 'package1.Lion'
    }
}