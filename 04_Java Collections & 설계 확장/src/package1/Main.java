package package1;

import role.*;
import java.util.*;

public class Main {
    private static List<Role> memberList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n======= 🦁 멤버 관리 시스템 =======");
            System.out.println("1. 멤버 등록 \n2. 전체 멤버 조회 \n3. 이름으로 검색 \n4. 종료");
            System.out.print("선택: ");
            int menu = sc.nextInt();
            sc.nextLine(); // 엔터 버퍼 비우기

            if (menu == 1) register();
            else if (menu == 2) showAll();
            else if (menu == 3) search();
            else if (menu == 4) break;
        }
    }

    private static void register() {
        System.out.println("\n— 📝 멤버 등록 —");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        int type = sc.nextInt(); sc.nextLine();

        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        for (Role m : memberList) {
            if (m.getName().trim().equals(name.trim())) {
                System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                return;
            }
        }

        System.out.print("🎓 전공: "); String major = sc.nextLine();
        System.out.print("📌 기수: "); int gen = sc.nextInt(); sc.nextLine();
        System.out.print("💻 파트(백엔드/프론트엔드/기획/디자인): "); String part = sc.nextLine();

        Role r;
        if (type == 1) {
            System.out.print("🆔 학번: "); String id = sc.nextLine();
            r = new Lion(name, major, gen, part, id);
        } else {
            System.out.print("💼 직책: "); String pos = sc.nextLine();
            r = new Staff(name, major, gen, part, pos);
        }

        memberList.add(r);
        System.out.println("✅ 등록 완료: " + name);
    }

    private static void showAll() {
        System.out.println("\n— 📋 전체 멤버 목록 —"); //
        if (memberList.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
            return;
        }
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println((i + 1) + ". " + memberList.get(i).getSummary());
        }
        System.out.println("📊 총 " + memberList.size() + "명"); //
    }

    private static void search() {
        System.out.println("\n— 🔍 이름으로 검색 —");
        System.out.print("\n검색할 이름: ");
        String name = sc.nextLine();
        for (Role m : memberList) {
            if (m.getName().equals(name)) {
                System.out.println(m.getDetailInfo());
                return;
            }
        }
        System.out.println("🔍 검색 결과가 없습니다.");
    }
}