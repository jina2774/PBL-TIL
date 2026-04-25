import policy.abstract_;
import policy.Lion;
import policy.Staff;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== 🦁 아기사자 정보 입력 ==========");
        System.out.print("이름: "); String lName = sc.nextLine();
        System.out.print("전공: "); String lMajor = sc.nextLine();
        System.out.print("기수: "); int lOrdinal = Integer.parseInt(sc.nextLine());
        System.out.print("파트: "); String lPart = sc.nextLine();
        System.out.print("학번: "); String lId = sc.nextLine();
        abstract_ lion = new Lion(lName, lMajor, lOrdinal, lPart, lId);

        System.out.println("\n========== 👤 운영진 정보 입력 ==========");
        System.out.print("이름: "); String sName = sc.nextLine();
        System.out.print("전공: "); String sMajor = sc.nextLine();
        System.out.print("기수: "); int sOrdinal = Integer.parseInt(sc.nextLine());
        System.out.print("파트: "); String sPart = sc.nextLine();
        System.out.print("직책: "); String sTitle = sc.nextLine();
        abstract_ staff = new Staff(sName, sMajor, sOrdinal, sPart, sTitle);

        System.out.println("\n========== 📋 결과 출력 ==========");
        printResult(lion);
        printResult(staff);
    }

    public static void printResult(abstract_ member) {
        System.out.println(member.getDetailInfo());
        boolean canSubmit = member.getPolicy().canSubmit();
        System.out.println("과제 제출 가능 여부: " + (canSubmit ? "✅ 가능" : "❌ 불가능"));
        System.out.println("-------------------------------------------");
    }
}