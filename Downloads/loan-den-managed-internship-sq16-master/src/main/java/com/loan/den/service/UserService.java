package com.loan.den.service;

import com.loan.den.model.User;

public interface UserService {
    User getUserByUsername(String username);

    User saveUser(User user);

    void updateUser(User user);

}