package com.likelion.assignment.controller;

import com.likelion.assignment.dto.AssignmentCreateRequest;
import com.likelion.assignment.dto.AssignmentResponse;
import com.likelion.assignment.dto.AssignmentUpdateRequest;
import com.likelion.assignment.service.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    // 특정 멤버에게 과제 등록
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> create(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request
    ) {
        AssignmentResponse response = assignmentService.create(memberId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 전체 과제 조회
    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentResponse>> findAll() {
        List<AssignmentResponse> responses = assignmentService.findAll();
        return ResponseEntity.ok(responses);
    }

    // 과제 제목 검색
    @GetMapping("/assignments/search")
    public ResponseEntity<List<AssignmentResponse>> searchByTitle(
            @RequestParam String keyword
    ) {
        List<AssignmentResponse> responses = assignmentService.searchByTitle(keyword);
        return ResponseEntity.ok(responses);
    }

    // 특정 멤버의 과제 조회
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> findByMemberId(
            @PathVariable Long memberId
    ) {
        List<AssignmentResponse> responses = assignmentService.findByMemberId(memberId);
        return ResponseEntity.ok(responses);
    }

    // 과제 단건 조회
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> findById(
            @PathVariable Long id
    ) {
        AssignmentResponse response = assignmentService.findById(id);
        return ResponseEntity.ok(response);
    }

    // 과제 수정
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request
    ) {
        AssignmentResponse response = assignmentService.update(id, request);
        return ResponseEntity.ok(response);
    }

    // 과제 삭제
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}