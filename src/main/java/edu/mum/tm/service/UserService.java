package edu.mum.tm.service;

import edu.mum.tm.domain.User;

public interface UserService {
    User saveUser(User user);

    User findUserByEmail(String email);
}
