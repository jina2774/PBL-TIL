package role;

public class Staff_policy_implementation implements policy_int {
    @Override
    public boolean canSubmit() {
        return false;
    }
}