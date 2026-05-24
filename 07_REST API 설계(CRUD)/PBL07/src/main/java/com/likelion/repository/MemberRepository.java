package com.likelion.repository;

import com.likelion.domain.role.Role;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    void updateByName(String name, Role member);
    boolean deleteByName(String name);
    boolean existsByName(String name);
}