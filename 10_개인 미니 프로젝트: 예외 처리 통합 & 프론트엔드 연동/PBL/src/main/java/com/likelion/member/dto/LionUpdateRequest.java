package com.likelion.member.dto;

public class LionUpdateRequest {

    private String name;
    private String major;
    private Integer generation;
    private String part;
    private String studentId;

    public LionUpdateRequest() {
    }

    public LionUpdateRequest(
            String name,
            String major,
            Integer generation,
            String part,
            String studentId
    ) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
        this.studentId = studentId;
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
}