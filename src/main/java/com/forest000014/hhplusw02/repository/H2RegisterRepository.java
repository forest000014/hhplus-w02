package com.forest000014.hhplusw02.repository;

import com.forest000014.hhplusw02.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface H2RegisterRepository extends RegisterRepository, JpaRepository<Register, Long> {

    Optional<Register> findByMember_UserId(String userId);
}
