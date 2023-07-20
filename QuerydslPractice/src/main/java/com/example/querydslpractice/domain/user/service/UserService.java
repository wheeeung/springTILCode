package com.example.querydslpractice.domain.user.service;

import com.example.querydslpractice.domain.user.controller.dto.UserDto;
import com.example.querydslpractice.domain.user.entity.User;
import com.example.querydslpractice.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public List<User> findAll(){
        return userRepository.querydslFindAll();
    }

    @Transactional
    public Page<User> findAllWithName(UserDto userDto) {
        Pageable pageable = PageRequest.of(userDto.getPage(), userDto.getSize());
        return userRepository.findAllWithName(pageable, userDto.getName());
    }
}
