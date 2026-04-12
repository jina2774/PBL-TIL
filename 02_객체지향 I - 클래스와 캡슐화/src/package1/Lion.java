package package1;

public class Lion {
    // 4번 준수: 3가지 접근 제어자를 각각 다르게 설정
    public String name;          // public
    String major;               // default (아무것도 안 적음)
    public int generation;     // private (실험을 위해 반드시 private 유지)

    // 3번 준수: 출력문 없이 초기화만 담당
    public Lion(String name, String major, int generation) {
        this.name = name;
        this.major = major;
        this.generation = generation;
    }

    // Step 2 요구사항: 객체 내부 검증 로직
    public boolean checkSelf() {
        if (name == null || name.isEmpty()) {
            System.out.println("❌ 이름이 비어 있습니다.");
            return false;
        } else if (major == null || major.isEmpty()) {
            System.out.println("❌ 전공이 비어 있습니다.");
            return false;
        } else if (generation < 1) {
            System.out.println("❌ 기수가 1 미만입니다.");
            return false;
        }
        return true;
    }

    // 공통 정보 출력 (메서드 내부에서는 private 필드인 generation에 접근 가능)
    public void printInfo() {
        System.out.printf("👤 이름: %s | 🎓 전공: %s | 📌 기수: %d\n",
                this.name, this.major, this.generation);
    }

    // 5번 준수: Getter/Setter는 우회 접근이므로 작성하지 않음 (삭제 완료)
}