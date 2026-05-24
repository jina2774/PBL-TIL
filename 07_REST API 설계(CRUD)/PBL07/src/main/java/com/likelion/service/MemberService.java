package com.likelion.service;

import com.likelion.dto.*;
import com.likelion.domain.role.*;
import com.likelion.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public LionResponse createLion(LionCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) return null;
        Lion lion = new Lion(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.save(lion);
        return LionResponse.from(lion);
    }

    public StaffResponse createStaff(StaffCreateRequest request) {
        if (memberRepository.existsByName(request.getName())) return null;
        Staff staff = new Staff(request.getName(), request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.save(staff);
        return StaffResponse.from(staff);
    }

    public Object findByName(String name) {
        Role member = memberRepository.findByName(name);
        if (member == null) return null;
        if (member instanceof Lion) return LionResponse.from((Lion) member);
        if (member instanceof Staff) return StaffResponse.from((Staff) member);
        return null;
    }

    public LionResponse updateLion(String name, LionUpdateRequest request) {
        if (!memberRepository.existsByName(name)) return null;
        Lion updatedLion = new Lion(name, request.getMajor(), request.getGeneration(), request.getPart(), request.getStudentId());
        memberRepository.updateByName(name, updatedLion);
        return LionResponse.from(updatedLion);
    }

    public StaffResponse updateStaff(String name, StaffUpdateRequest request) {
        if (!memberRepository.existsByName(name)) return null;
        Staff updatedStaff = new Staff(name, request.getMajor(), request.getGeneration(), request.getPart(), request.getPosition());
        memberRepository.updateByName(name, updatedStaff);
        return StaffResponse.from(updatedStaff);
    }

    public boolean deleteMember(String name) {
        return memberRepository.deleteByName(name);
    }
}