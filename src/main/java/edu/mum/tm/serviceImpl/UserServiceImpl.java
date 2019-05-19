package edu.mum.tm.serviceImpl;

import edu.mum.tm.domain.User;
import edu.mum.tm.repository.UserRepository;
import edu.mum.tm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        return userRepository.save(user);
    }
}
