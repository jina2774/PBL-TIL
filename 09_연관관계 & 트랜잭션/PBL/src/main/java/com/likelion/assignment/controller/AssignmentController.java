package com.likelion.assignment.controller;

import com.likelion.assignment.dto.AssignmentCreateRequest;
import com.likelion.assignment.dto.AssignmentResponse;
import com.likelion.assignment.dto.AssignmentUpdateRequest;
import com.likelion.assignment.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    // 1. 과제 등록 API
    @PostMapping("/members/{memberId}/assignments")
    public ResponseEntity<AssignmentResponse> createAssignment(
            @PathVariable Long memberId,
            @RequestBody AssignmentCreateRequest request) {
        AssignmentResponse response = assignmentService.createAssignment(memberId, request);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 2. 멤버별 과제 목록 조회 API
    @GetMapping("/members/{memberId}/assignments")
    public ResponseEntity<List<AssignmentResponse>> getAssignmentsByMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(assignmentService.findByMemberId(memberId));
    }

    // 3. 과제 단건 조회 API
    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> getAssignment(@PathVariable Long id) {
        AssignmentResponse response = assignmentService.findById(id);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    // 4. 과제 수정 API
    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentResponse> updateAssignment(
            @PathVariable Long id,
            @RequestBody AssignmentUpdateRequest request) {
        AssignmentResponse response = assignmentService.updateAssignment(id, request);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    // 5. 과제 삭제 API
    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        if (!assignmentService.deleteAssignment(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}