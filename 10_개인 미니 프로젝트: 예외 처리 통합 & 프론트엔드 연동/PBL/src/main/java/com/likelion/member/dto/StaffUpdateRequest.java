package com.likelion.member.dto;

public class StaffUpdateRequest {

    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String studentId;
    private String position;

    public StaffUpdateRequest() {
    }

    public StaffUpdateRequest(
            String name,
            String major,
            Integer generation,
            String part,
            String studentId,
            String position
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
        this.position = position;
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
}