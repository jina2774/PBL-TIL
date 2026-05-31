package com.likelion.domain;

public enum RoleType {
    LION("아기사자"),
    STAFF("운영진");

    private final String displayName;

    // 생성자
    RoleType(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }
}