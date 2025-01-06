package com.ll.sb_25_01.domain.member.repository;

import com.ll.sb_25_01.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
