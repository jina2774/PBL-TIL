package com.likelion.member.service;

import com.likelion.global.exception.DuplicateMemberException;
import com.likelion.global.exception.MemberNotFoundException;
import com.likelion.member.domain.Member;
import com.likelion.member.dto.LionCreateRequest;
import com.likelion.member.dto.LionUpdateRequest;
import com.likelion.member.dto.MemberResponse;
import com.likelion.member.dto.StaffCreateRequest;
import com.likelion.member.dto.StaffUpdateRequest;
import com.likelion.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 전체 멤버 조회 + 파트별 필터링
    public List<MemberResponse> findAll(String part) {
        List<Member> members;

        if (part == null || part.isBlank()) {
            members = memberRepository.findAll();
        } else {
            members = memberRepository.findByPart(part);
        }

        return members.stream()
                .map(MemberResponse::from)
                .toList();
    }

    public MemberResponse findById(Long id) {
        Member member = getMemberById(id);
        return MemberResponse.from(member);
    }

    @Transactional
    public MemberResponse createLion(LionCreateRequest request) {
        validateDuplicateName(request.getName());

        Member member = Member.createLion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        Member savedMember = memberRepository.save(member);
        return MemberResponse.from(savedMember);
    }

    @Transactional
    public MemberResponse createStaff(StaffCreateRequest request) {
        validateDuplicateName(request.getName());

        Member member = Member.createStaff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId(),
                request.getPosition()
        );

        Member savedMember = memberRepository.save(member);

        return MemberResponse.from(savedMember);
    }

    @Transactional
    public MemberResponse updateLion(Long id, LionUpdateRequest request) {
        Member member = getMemberById(id);

        member.updateLion(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId()
        );

        return MemberResponse.from(member);
    }

    @Transactional
    public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
        Member member = getMemberById(id);

        member.updateStaff(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                request.getStudentId(),
                request.getPosition()
        );

        return MemberResponse.from(member);
    }

    @Transactional
    public void delete(Long id) {
        Member member = getMemberById(id);
        memberRepository.delete(member);
    }

    private Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 멤버입니다. id=" + id));
    }

    private void validateDuplicateName(String name) {
        if (memberRepository.existsByName(name)) {
            throw new DuplicateMemberException("이미 존재하는 멤버 이름입니다. name=" + name);
        }
    }
}