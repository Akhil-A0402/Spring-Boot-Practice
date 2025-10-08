package com.example.SpringBootPractice.jpaPractice.part1.withoutJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jpa/")
public class WithoutJPAContorller {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/withoutJPA")
    public void initateWithoutJpa() {
        userDAO.createUserTable();
        userDAO.createUser("testing", 01);
        userDAO.createUser("testing2", 02);
        userDAO.readUsers();
    }
}
