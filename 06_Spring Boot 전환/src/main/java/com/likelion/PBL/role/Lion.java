package com.likelion.PBL.role;
import com.likelion.PBL.policy.LionSubmissionPolicy;

public class Lion extends Role {
    public Lion(String n, String m, int g, String p, String s) {
        super(n, m, g, p, s, new LionSubmissionPolicy());
    }
    @Override public String getRoleName() { return "아기사자"; }
}