package com.forest000014.hhplusw02.repository;

import com.forest000014.hhplusw02.entity.Register;

import java.util.Optional;

public interface RegisterRepository {

    Optional<Register> findByMember_UserId(String userId);
    long count();
    Register save(Register register);
}
