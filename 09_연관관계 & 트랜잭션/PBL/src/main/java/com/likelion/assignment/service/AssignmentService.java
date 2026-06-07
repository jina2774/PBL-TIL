package com.likelion.assignment.service;

import com.likelion.assignment.domain.Assignment;
import com.likelion.assignment.dto.AssignmentCreateRequest;
import com.likelion.assignment.dto.AssignmentResponse;
import com.likelion.assignment.dto.AssignmentUpdateRequest;
import com.likelion.assignment.repository.AssignmentRepository;
import com.likelion.member.domain.Member;
import com.likelion.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    // 1. 과제 등록 
    @Transactional
    public AssignmentResponse createAssignment(Long memberId, AssignmentCreateRequest request) {
        Member member = memberRepository.findById(memberId).orElse(null);
        if (member == null) return null;

        Assignment assignment = new Assignment(request.getTitle(), request.getDescription(), member);
        return AssignmentResponse.from(assignmentRepository.save(assignment));
    }

    // 2. 멤버별 과제 목록 조회
    public List<AssignmentResponse> findByMemberId(Long memberId) {
        return assignmentRepository.findByMemberId(memberId).stream()
                .map(AssignmentResponse::from)
                .collect(Collectors.toList());
    }

    // 3. 과제 단건 조회
    public AssignmentResponse findById(Long id) {
        return assignmentRepository.findById(id)
                .map(AssignmentResponse::from)
                .orElse(null);
    }

    // 4. 과제 수정
    @Transactional
    public AssignmentResponse updateAssignment(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment == null) return null;

        assignment.updateInfo(request.getTitle(), request.getDescription());
        return AssignmentResponse.from(assignment);
    }

    // 5. 과제 삭제
    @Transactional
    public boolean deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) return false;
        assignmentRepository.deleteById(id);
        return true;
    }
}