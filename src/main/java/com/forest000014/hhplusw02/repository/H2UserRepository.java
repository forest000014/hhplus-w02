package com.forest000014.hhplusw02.repository;

import com.forest000014.hhplusw02.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2UserRepository extends UserRepository, JpaRepository<Member, Long> {
}
