package com.likelion.PBL.service;
import com.likelion.PBL.repository.MemberRepository;
import com.likelion.PBL.role.Role;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository repository;

    //@Autowired
    public MemberService(MemberRepository repository) { this.repository = repository; }
    public boolean registerMember(Role role) {
        if (repository.isDuplicate(role.getName())) return false;
        repository.save(role); return true;
    }

    public Role searchMember(String name) { return repository.findByName(name); }
    public List<Role> getAllMembers() { return repository.findAll(); }
}