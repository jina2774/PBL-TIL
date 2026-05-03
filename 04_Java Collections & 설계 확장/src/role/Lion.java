package role;
import policy.LionSubmissionPolicy;

public class Lion extends Role {
    private String studentId;
    public Lion(String n, String m, int g, String p, String id) {
        super(n, m, g, p); this.studentId = id;
        this.submissionPolicy = new LionSubmissionPolicy();
    }
    @Override
    public String getSummary() { return "[아기사자] " + getName() + " - " + getGeneration() + "기"; }

    @Override
    public String getDetailInfo() {
        return "✨ [검색 결과]\n" +
                "🎭 역할: 아기사자\n" +
                "이름: " + getName() + " | 전공: " + getMajor() + " | 기수: " + getGeneration() + " | 파트: " + getPart() + "\n" +
                "학번: " + studentId + "\n" +
                "📝 과제 제출 가능 여부: " + getSubmissionStatus();
    }
}