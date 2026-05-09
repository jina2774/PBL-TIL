package package1;
import role.*;
import java.util.Scanner;

public class Main {
    private static MemberService service = new MemberService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- [Package1] 멤버 시스템 (Step 1) ---");
            System.out.println("1. 등록 | 2. 전체조회 | 3. 이름검색 | 0. 종료");
            System.out.print("메뉴 선택: ");
            try {
                int menu = Integer.parseInt(sc.nextLine());
                if (menu == 1) register();
                else if (menu == 2) showAll();
                else if (menu == 3) search();
                else if (menu == 0) { service.exit(); break; }
            } catch (Exception e) { System.out.println("⚠️ 메뉴 선택은 숫자만 가능합니다!"); }
        }
    }

    private static void register() {
        System.out.print("👤 역할 선택 (1: 아기사자, 2: 운영진): ");
        String type = sc.nextLine();
        System.out.println("\n📝 정보 입력");
        System.out.print("이름: "); String name = sc.nextLine();
        System.out.print("전공: "); String major = sc.nextLine();
        System.out.print("기수: "); int gen = Integer.parseInt(sc.nextLine());
        System.out.print("파트: "); String part = sc.nextLine();
        System.out.print("학번: "); String sid = sc.nextLine();

        Role r = type.equals("1") ? new Lion(name,major,gen,part,sid) : new Staff(name,major,gen,part,sid);
        if (service.registerMember(r)) System.out.println("\n✅ 등록 완료: " + name);
        else System.out.println("\n❌ 에러: 이미 존재하는 이름입니다.");
    }

    private static void showAll() {
        for (Role r : service.getAllMembers()) System.out.println("[" + r.getRoleName() + "] " + r.getName());
    }

    private static void search() {
        System.out.print("🔍 검색할 이름: ");
        String name = sc.nextLine();
        Role r = service.searchMember(name);
        if (r != null) {
            System.out.println("\n🎯 ===== 검색 결과 =====");
            System.out.println("👤 역할: " + r.getRoleName());
            System.out.println("📌 이름: " + r.getName() + " | 🎓 전공: " + r.getMajor() + " | 🔢 기수: " + r.getGeneration() + " | 💻 파트: " + r.getPart());
            System.out.println("🆔 학번: " + r.getStudentId());
            System.out.println("📝 과제 제출 가능: " + (r.canSubmit() ? "✅ 가능" : "❌ 불가능"));
        } else System.out.println("🔍 결과가 없습니다.");
    }
}