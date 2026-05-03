package role;
import policy.SubmissionPolicy;

public abstract class Role {
    private String name, major, part;
    private int generation;
    protected SubmissionPolicy submissionPolicy;

    public Role(String name, String major, int generation, String part) {
        this.name = name; this.major = major; this.generation = generation; this.part = part;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }

    public String getSubmissionStatus() {
        return submissionPolicy.canSubmit() ? "✅ 가능" : "❌ 불가능";
    }

    public abstract String getSummary();
    public abstract String getDetailInfo();
}