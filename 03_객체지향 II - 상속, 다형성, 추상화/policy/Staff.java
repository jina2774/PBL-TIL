package policy;

import role.Staff_policy_implementation;
import role.policy_int;

public class Staff extends abstract_ {
    private String roleTitle;

    public Staff(String name, String major, int ordinal, String part, String roleTitle) {
        super(name, major, ordinal, part);
        this.roleTitle = roleTitle;
    }

    @Override
    public policy_int getPolicy() {
        return new Staff_policy_implementation();
    }

    @Override
    public String getDetailInfo() {
        return "👤 역할: 운영진 | 이름: " + getName() + " | 전공: " + getMajor() +
                " | 기수: " + getOrdinal() + " | 파트: " + getPart() + " | 직책: " + roleTitle;
    }
}