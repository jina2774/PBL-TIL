package policy;

import role.Lion_policy_implementation;
import role.policy_int;

public class Lion extends abstract_ {
    private String studentId;

    public Lion(String name, String major, int ordinal, String part, String studentId) {
        super(name, major, ordinal, part);
        this.studentId = studentId;
    }

    @Override
    public policy_int getPolicy() {
        return new Lion_policy_implementation();
    }

    @Override
    public String getDetailInfo() {
        return "🦁 역할: 아기사자 | 이름: " + getName() + " | 전공: " + getMajor() +
                " | 기수: " + getOrdinal() + " | 파트: " + getPart() + " | 학번: " + studentId;
    }
}