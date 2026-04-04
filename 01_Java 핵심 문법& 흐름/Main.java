import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int count = 0;

            while (true) {
                try {
                    System.out.print("🦁 저장할 아기사자 수를 5 이상 입력해주세요: ");
                    count = sc.nextInt();
                    sc.nextLine();

                    if (count >= 5) {
                        break;
                    } else {
                        System.out.println("⚠️ 오류: 5명 이상의 숫자를 입력해야 합니다.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❗ [오류] 숫자만 입력할 수 있습니다.");
                    sc.nextLine();
                }
            }

            String[] babyLions = new String[count];
            System.out.println("\n✏️ 아기사자 이름을 입력해주세요.");

            for (int i = 0; i < count; i++) {
                while (true) {
                    System.out.print((i + 1) + "번째 이름: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("⚠️ 이름이 비어있습니다. 다시 입력해주세요.");
                        continue;
                    }

                    boolean isDuplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (babyLions[j].equals(name)) {
                            isDuplicate = true;
                            break;
                        }
                    }

                    if (isDuplicate) {
                        System.out.println("⚠️ 이미 등록된 이름입니다. 다시 입력해주세요.");
                    } else {
                        babyLions[i] = name;
                        break;
                    }
                }
            }

            System.out.println("\n📋 아기사자 명단을 최종적으로 출력합니다.");
            for (int i = 0; i < babyLions.length; i++) {
                System.out.println("🦁 " + (i + 1) + ". " + babyLions[i]);
            }
            System.out.println("============================");

            boolean shouldExit = false;
            while (true) {
                System.out.println("⛔ 프로그램을 종료하려면 'exit'를 입력하세요.");
                System.out.println("🔄 계속 아기사자를 등록하려면 'restart'를 입력하세요.");
                System.out.print("명령어 입력: ");
                String command = sc.nextLine();

                if (command.equals("exit")) {
                    System.out.println("👋 아기사자 명단 관리 프로그램을 종료합니다.");
                    shouldExit = true;
                    break;
                } else if (command.equals("restart")) {
                    break;
                } else {
                    System.out.println("⚠️ 잘못된 명령어입니다. 다시 입력해주세요.");
                }
            }

            if (shouldExit) break;
        }
        sc.close();
    }
}
