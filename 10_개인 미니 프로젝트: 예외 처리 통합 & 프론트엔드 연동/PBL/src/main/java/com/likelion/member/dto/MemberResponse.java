package com.likelion.member.dto;

import com.likelion.member.domain.Member;
import com.likelion.member.domain.RoleType;

public class MemberResponse {

    private Long id;
    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String studentId;
    private String position;
    private RoleType roleType;
    private String roleName;

    public MemberResponse(
            Long id,
            String name,
            String major,
            Integer generation,
            String part,
            String studentId,
            String position,
            RoleType roleType,
            String roleName
    ) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.position = position;
        this.roleType = roleType;
        this.roleName = roleName;
    }

    public static MemberResponse from(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getMajor(),
                member.getGeneration(),
                member.getPart(),
                member.getStudentId(),
                member.getPosition(),
                member.getRoleType(),
                member.getRoleType().getDisplayName()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public Integer getGeneration() {
        return generation;
    }

    public String getPart() {
        return part;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPosition() {
        return position;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public String getRoleName() {
        return roleName;
    }
}