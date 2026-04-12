package package1;

import java.util.Scanner;

public class Step2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🦁 아기사자 이름을 입력해주세요.");
        String name = sc.nextLine();

        System.out.println("🎓 전공을 입력해주세요.");
        String major = sc.nextLine();

        System.out.println("📌 기수를 입력해주세요.");
        int generation = sc.nextInt();

        // 1. 일단 객체부터 생성 (Step 2의 특징)
        Lion lion = new Lion(name, major, generation);
        System.out.println("⏩ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");

        // 2. 객체 스스로 검증하게 시킴
        if (lion.checkSelf()) {
            // 성공 시
            System.out.println("✅ 아기사자 객체가 자신의 상태를 정상으로 판단했습니다.");
            System.out.println("🦁 아기사자 정보를 출력합니다.");
            System.out.printf("👤 이름: %s | 🎓 전공: %s | 📌 기수: %d\n",
                    lion.name, lion.major, lion.generation);
        } else {
            // 실패 시
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
        }
    }
}