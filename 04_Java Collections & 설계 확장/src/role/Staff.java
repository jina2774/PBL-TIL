package role;
import policy.StaffSubmissionPolicy;

public class Staff extends Role {
    private String position;
    public Staff(String n, String m, int g, String p, String pos) {
        super(n, m, g, p); this.position = pos;
        this.submissionPolicy = new StaffSubmissionPolicy();
    }
    @Override
    public String getSummary() { return "[운영진] " + getName() + " - " + getGeneration() + "기"; }

    @Override
    public String getDetailInfo() {
        return "✨ [검색 결과]\n" +
                "🎭 역할: 운영진\n" +
                "이름: " + getName() + " | 전공: " + getMajor() + " | 기수: " + getGeneration() + " | 파트: " + getPart() + "\n" +
                "직책: " + position + "\n" +
                "📝 과제 제출 가능 여부: " + getSubmissionStatus();
    }
}