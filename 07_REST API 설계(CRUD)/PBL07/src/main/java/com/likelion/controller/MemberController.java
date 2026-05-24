package com.likelion.controller;

import com.likelion.dto.*;
import com.likelion.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/lions")
    public ResponseEntity<?> createLion(@RequestBody LionCreateRequest request) {
        Object response = memberService.createLion(request);
        if (response == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/staffs")
    public ResponseEntity<?> createStaff(@RequestBody StaffCreateRequest request) {
        Object response = memberService.createStaff(request);
        if (response == null) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Object response = memberService.findByName(name);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/lions/{name}")
    public ResponseEntity<?> updateLion(@PathVariable String name, @RequestBody LionUpdateRequest request) {
        LionResponse response = memberService.updateLion(name, request);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/staffs/{name}")
    public ResponseEntity<?> updateStaff(@PathVariable String name, @RequestBody StaffUpdateRequest request) {
        StaffResponse response = memberService.updateStaff(name, request);
        if (response == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean isDeleted = memberService.deleteMember(name);
        if (!isDeleted) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.noContent().build();
    }
}