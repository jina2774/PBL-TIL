package policy;

public class LionSubmissionPolicy implements SubmissionPolicy {
    @Override public String getPolicyName() { return "Lion Submission Policy"; }
    @Override public boolean isSubmittable() { return true; }
}