package com.example.springtilcode.domain.user.service;

import com.example.springtilcode.domain.user.controller.dto.QuerydslDto;
import com.example.springtilcode.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public List<QuerydslDto> findUserInfo(long id){
        return userRepository.findByUser(id).orElseThrow(() -> new RuntimeException("not found"));
    }
}
