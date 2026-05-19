package com.likelion.PBL.repository;
import com.likelion.PBL.role.Role;
import java.util.List;

public interface MemberRepository {
    void save(Role role);
    Role findByName(String name);
    List<Role> findAll();
    boolean isDuplicate(String name);
}