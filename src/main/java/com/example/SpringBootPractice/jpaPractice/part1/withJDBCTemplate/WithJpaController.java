package com.example.SpringBootPractice.jpaPractice.part1.withJDBCTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jpa/")
public class WithJpaController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/withJdbcTemplate")
    public void initateWithoutJpa() {
        userRepository.createTable();
        userRepository.insertUser("testing", 01);
        userRepository.insertUser("testing2", 02);
        List<User> userList = userRepository.getUsers();
        userList.stream().forEach(e -> {
            System.out.println(e.toString());
        });
    }
}
