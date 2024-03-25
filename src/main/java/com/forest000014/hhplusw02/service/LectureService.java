package com.forest000014.hhplusw02.service;

import com.forest000014.hhplusw02.dto.LectureRequestDto;
import com.forest000014.hhplusw02.dto.LectureResponseDto;
import com.forest000014.hhplusw02.entity.Register;
import com.forest000014.hhplusw02.entity.Member;
import com.forest000014.hhplusw02.repository.RegisterRepository;
import com.forest000014.hhplusw02.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

@Service
public class LectureService {

    private static final Logger logger = LoggerFactory.getLogger(LectureService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterRepository registerRepository;

    private final LocalDateTime lectureOpenTime = LocalDateTime.of(2024, Month.APRIL, 21, 13, 0);
    private final long MAX_REGISTER_USER = 30;

    public LectureResponseDto register(LectureRequestDto requestDto, LocalDateTime currentTime) {
        logger.info("특강 신청 요청 - userId[{}], currentTime[{}]", requestDto.getUserId(), currentTime);

        if (currentTime.isBefore(lectureOpenTime)) {
            throw new RuntimeException("특강 신청이 아직 열리지 않았습니다.");
        }

        Optional<Member> userOptional = userRepository.findByUserId(requestDto.getUserId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("존재하지 않는 userId 입니다.");
        }

        if (registerRepository.findByMember_UserId(requestDto.getUserId()).isEmpty()) {
            throw new RuntimeException("이미 특강 신청을 했습니다.");
        }

        if (registerRepository.count() >= MAX_REGISTER_USER) {
            throw new RuntimeException("정원이 가득 찼습니다.");
        }

        Register register = new Register();
//        register.setUser(userOptional.get());
        Member x = new Member();
        register.setMember(x);
        registerRepository.save(register);
        logger.info("특강 신청 성공 - userId[{}]", requestDto.getUserId());

        return new LectureResponseDto(requestDto.getUserId(), true);
    }
}
