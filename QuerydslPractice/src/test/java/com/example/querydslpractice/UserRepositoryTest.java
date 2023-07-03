package com.example.querydslpractice;

import com.example.querydslpractice.domain.user.entity.User;
import com.example.querydslpractice.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void querydslTest() {
        List<User> userList = userRepository.querydslFindAll();

        userList.iterator().forEachRemaining(user -> {
            System.out.println("user = " + user);
        });
    }


    @Test
    public void createUser() {
        User user = User.builder()
                .email("whee050916@gmail.com")
                .password("1234")
                .name("hwieung")
                .build();
        userRepository.save(user);
    }

    @Test
    public void findAllWithName() {
        int page = 1;
        int size = 5;
        String name = "hwieung";

        Pageable pageable = PageRequest.of(page, size);
        Page<User> userList = userRepository.findAllWithName(pageable, name);

        System.out.println(userList.getTotalPages());
    }
}
