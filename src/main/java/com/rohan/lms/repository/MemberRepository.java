package com.rohan.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohan.lms.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
