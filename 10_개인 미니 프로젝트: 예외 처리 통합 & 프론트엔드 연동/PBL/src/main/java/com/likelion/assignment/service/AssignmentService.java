package com.likelion.assignment.service;

import com.likelion.assignment.domain.Assignment;
import com.likelion.assignment.dto.AssignmentCreateRequest;
import com.likelion.assignment.dto.AssignmentResponse;
import com.likelion.assignment.dto.AssignmentUpdateRequest;
import com.likelion.assignment.repository.AssignmentRepository;
import com.likelion.global.exception.AssignmentNotFoundException;
import com.likelion.global.exception.MemberNotFoundException;
import com.likelion.member.domain.Member;
import com.likelion.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MemberRepository memberRepository;

    public AssignmentService(
            AssignmentRepository assignmentRepository,
            MemberRepository memberRepository
    ) {
        this.assignmentRepository = assignmentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public AssignmentResponse create(Long memberId, AssignmentCreateRequest request) {
        Member member = getMemberById(memberId);

        Assignment assignment = new Assignment(
                request.getTitle(),
                request.getDescription(),
                member
        );

        Assignment savedAssignment = assignmentRepository.save(assignment);
        return AssignmentResponse.from(savedAssignment);
    }

    // 전체 과제 조회
    public List<AssignmentResponse> findAll() {
        return assignmentRepository.findAll()
                .stream()
                .map(AssignmentResponse::from)
                .toList();
    }

    // 특정 멤버의 과제 조회
    public List<AssignmentResponse> findByMemberId(Long memberId) {
        getMemberById(memberId);

        return assignmentRepository.findByMemberId(memberId)
                .stream()
                .map(AssignmentResponse::from)
                .toList();
    }

    // 과제 단건 조회
    public AssignmentResponse findById(Long id) {
        Assignment assignment = getAssignmentById(id);
        return AssignmentResponse.from(assignment);
    }

    // 과제 제목 검색
    public List<AssignmentResponse> searchByTitle(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }

        return assignmentRepository.findByTitleContaining(keyword)
                .stream()
                .map(AssignmentResponse::from)
                .toList();
    }

    @Transactional
    public AssignmentResponse update(Long id, AssignmentUpdateRequest request) {
        Assignment assignment = getAssignmentById(id);

        assignment.update(
                request.getTitle(),
                request.getDescription()
        );

        return AssignmentResponse.from(assignment);
    }

    @Transactional
    public void delete(Long id) {
        Assignment assignment = getAssignmentById(id);
        assignmentRepository.delete(assignment);
    }

    private Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 멤버입니다. id=" + memberId));
    }

    private Assignment getAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new AssignmentNotFoundException("존재하지 않는 과제입니다. id=" + assignmentId));
    }
}