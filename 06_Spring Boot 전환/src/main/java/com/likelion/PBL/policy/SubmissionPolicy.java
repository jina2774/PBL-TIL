package com.likelion.PBL.policy;

public interface SubmissionPolicy {
    String getPolicyName();
    boolean isSubmittable(); // 과제 제출 가능 여부 (✅ 가능 / ❌ 불가능)
}