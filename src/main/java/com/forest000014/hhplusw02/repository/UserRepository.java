package com.forest000014.hhplusw02.repository;

import com.forest000014.hhplusw02.entity.Member;

import java.util.Optional;

public interface UserRepository {

    Optional<Member> findByUserId(String userId);
}
