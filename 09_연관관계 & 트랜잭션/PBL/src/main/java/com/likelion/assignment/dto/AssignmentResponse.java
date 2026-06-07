package com.likelion.assignment.dto;

import com.likelion.assignment.domain.Assignment;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AssignmentResponse {
    private Long id;
    private String title;
    private String description;
    private Long memberId;
    private String memberName;

    // 엔티티를 DTO로 변환하는 팩토리 메서드
    public static AssignmentResponse from(Assignment assignment) {
        return AssignmentResponse.builder()
                .id(assignment.getId())
                .title(assignment.getTitle())
                .description(assignment.getDescription())
                .memberId(assignment.getMember().getId())
                .memberName(assignment.getMember().getName())
                .build();
    }
}