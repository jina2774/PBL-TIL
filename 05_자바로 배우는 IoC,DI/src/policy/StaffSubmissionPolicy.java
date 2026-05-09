package policy;

public class StaffSubmissionPolicy implements SubmissionPolicy {
    @Override public String getPolicyName() { return "Staff Submission Policy"; }
    @Override public boolean isSubmittable() { return false; }
}