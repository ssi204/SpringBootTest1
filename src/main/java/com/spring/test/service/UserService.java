package com.spring.test.service;

import com.spring.test.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    void delete(long id);
}
