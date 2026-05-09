package role;
import policy.StaffSubmissionPolicy;

public class Staff extends Role {
    public Staff(String n, String m, int g, String p, String s) {
        super(n, m, g, p, s, new StaffSubmissionPolicy());
    }
    @Override public String getRoleName() { return "운영진"; }
}