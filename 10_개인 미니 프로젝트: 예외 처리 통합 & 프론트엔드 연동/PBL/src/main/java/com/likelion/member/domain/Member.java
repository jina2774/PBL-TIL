package com.likelion.member.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String studentId;
    private String position;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    protected Member() {
    }

    private Member(
            String name,
            String major,
            Integer generation,
            String part,
            String studentId,
            String position,
            RoleType roleType
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.position = position;
        this.roleType = roleType;
    }

    public static Member createLion(
            String name,
            String major,
            Integer generation,
            String part,
            String studentId
    ) {
        return new Member(
                name,
                major,
                generation,
                part,
                studentId,
                null,
                RoleType.LION
        );
    }

    public static Member createStaff(
            String name,
            String major,
            Integer generation,
            String part,
            String studentId,
            String position
    ) {
        return new Member(
                name,
                major,
                generation,
                part,
                studentId,
                position,
                RoleType.STAFF
        );
    }

    public void updateLion(
            String name,
            String major,
            Integer generation,
            String part,
            String studentId
    ) {
        this.name = keepIfBlank(name, this.name);
        this.major = keepIfBlank(major, this.major);
        this.generation = keepIfNullOrZero(generation, this.generation);
        this.part = keepIfBlank(part, this.part);
        this.studentId = keepIfBlank(studentId, this.studentId);
        this.roleType = RoleType.LION;
    }

    public void updateStaff(
            String name,
            String major,
            Integer generation,
            String part,
            String studentId,
            String position
    ) {
        this.name = keepIfBlank(name, this.name);
        this.major = keepIfBlank(major, this.major);
        this.generation = keepIfNullOrZero(generation, this.generation);
        this.part = keepIfBlank(part, this.part);
        this.studentId = keepIfBlank(studentId, this.studentId);
        this.position = keepIfBlank(position, this.position);
        this.roleType = RoleType.STAFF;
    }

    private String keepIfBlank(String newValue, String oldValue) {
        if (newValue == null || newValue.isBlank()) {
            return oldValue;
        }
        return newValue;
    }

    private Integer keepIfNullOrZero(Integer newValue, Integer oldValue) {
        if (newValue == null || newValue == 0) {
            return oldValue;
        }
        return newValue;
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
}