package com.likelion.member.service;

import com.likelion.member.domain.Member;
import com.likelion.member.domain.RoleType;
import com.likelion.member.dto.*;
import com.likelion.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 1. 클래스 레벨에 적용
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional // 2. 데이터 변경 메서드에 적용
    public Member createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) return null;
        Member member = new Member(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), RoleType.LION, request.getStudentId(), null);
        return memberRepository.save(member);
    }

    @Transactional // 2. 데이터 변경 메서드에 적용
    public Member createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) return null;
        Member member = new Member(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), RoleType.STAFF, null, request.getPosition());
        return memberRepository.save(member);
    }

    public List<Member> findAll() { return memberRepository.findAll(); }

    public Member findById(Long id) { return memberRepository.findById(id).orElse(null); }

    @Transactional // 2. 데이터 변경 메서드에 적용
    public Member updateLion(Long id, LionUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.LION) return null;
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updateStudentId(request.getStudentId());
        return memberRepository.save(member);
    }

    @Transactional // 2. 데이터 변경 메서드에 적용
    public Member updateStaff(Long id, StaffUpdateRequest request) {
        Member member = memberRepository.findById(id).orElse(null);
        if (member == null || member.getRoleType() != RoleType.STAFF) return null;
        member.updateInfo(request.getMajor(), request.getGeneration(), request.getPart());
        member.updatePosition(request.getPosition());
        return memberRepository.save(member);
    }

    @Transactional // 2. 데이터 변경 메서드에 적용
    public boolean deleteMember(Long id) {
        if (!memberRepository.existsById(id)) return false;
        memberRepository.deleteById(id);
        return true;
    }
}