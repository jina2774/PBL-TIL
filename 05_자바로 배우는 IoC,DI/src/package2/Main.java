package package2;
import role.*;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        int choice = Integer.parseInt(sc.nextLine());

        MemberRepository repo = (choice == 1) ? new MemoryMemberRepository() : new MockMemberRepository();
        MemberService service = new MemberService(repo);

        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");
            System.out.println("1. ➕ 멤버 등록 | 2. 📋 전체 멤버 조회 | 3. 🔍 이름으로 검색 | 4. 🚪 종료");
            System.out.print("선택: ");
            try {
                int menu = Integer.parseInt(sc.nextLine());
                if (menu == 1) register(service);
                else if (menu == 2) showAll(service);
                else if (menu == 3) search(service);
                else if (menu == 4) break;
            } catch (Exception e) { System.out.println("⚠️ 숫자만 입력하세요!"); }
        }
    }

    private static void register(MemberService s) {
        System.out.print("👤 역할 선택 (1: 아기사자, 2: 운영진): ");
        String type = sc.nextLine();
        System.out.println("\n📝 정보 입력");
        System.out.print("이름: "); String name = sc.nextLine();
        System.out.print("전공: "); String major = sc.nextLine();
        System.out.print("기수: "); int gen = Integer.parseInt(sc.nextLine());
        System.out.print("파트: "); String part = sc.nextLine();
        System.out.print("학번: "); String sid = sc.nextLine();

        Role r = type.equals("1") ? new Lion(name,major,gen,part,sid) : new Staff(name,major,gen,part,sid);
        if (s.registerMember(r)) System.out.println("\n✅ 등록 완료: " + name);
        else System.out.println("\n❌ 에러: 이미 존재하는 이름입니다.");
    }

    private static void showAll(MemberService s) {
        for (Role r : s.getAllMembers()) System.out.println("[" + r.getRoleName() + "] " + r.getName());
    }

    private static void search(MemberService s) {
        System.out.print("🔍 검색할 이름: ");
        String name = sc.nextLine();
        Role r = s.searchMember(name);
        if (r != null) {
            System.out.println("\n🎯 ===== 검색 결과 =====");
            System.out.println("👤 역할: " + r.getRoleName());
            System.out.println("📌 이름: " + r.getName() + " | 🎓 전공: " + r.getMajor() + " | 🔢 기수: " + r.getGeneration() + " | 💻 파트: " + r.getPart());
            System.out.println("🆔 학번: " + r.getStudentId());
            System.out.println("📝 과제 제출 가능: " + (r.canSubmit() ? "✅ 가능" : "❌ 불가능"));
        } else System.out.println("🔍 결과가 없습니다.");
    }
}