package policy;

import role.policy_int;

public abstract class abstract_ {

    private String name;
    private String major;
    private int ordinal;
    private String part;

    public abstract_(String name, String major, int ordinal, String part) {
        this.name = name;
        this.major = major;
        this.ordinal = ordinal;
        this.part = part;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getOrdinal() { return ordinal; }
    public String getPart() { return part; }

    public abstract policy_int getPolicy(); // role 패키지의 인터페이스 반환
    public abstract String getDetailInfo();
}