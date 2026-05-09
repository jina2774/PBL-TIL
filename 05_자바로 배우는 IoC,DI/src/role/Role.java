package role;
import policy.SubmissionPolicy;

public abstract class Role {
    private String name, major, part, studentId;
    private int generation;
    protected SubmissionPolicy policy;

    public Role(String name, String major, int generation, String part, String studentId, SubmissionPolicy policy) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.policy = policy;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getGeneration() { return generation; }
    public String getPart() { return part; }
    public String getStudentId() { return studentId; }
    public boolean canSubmit() { return policy.isSubmittable(); }
    public abstract String getRoleName();
}