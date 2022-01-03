package com.switchfully.order.spring_exercise.security;

import com.switchfully.order.spring_exercise.domain.user.User;
import com.switchfully.order.spring_exercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public SecureUser loadUserByUsername(String username) throws UsernameNotFoundException {
            User userDb = userRepository.findUserByUsername(username).orElseThrow(() -> {
                throw new UsernameNotFoundException("Could not find user in DB");
            });
        return new SecureUser(userDb);
    }

    public void addUser(User user) {
        if(userDoesNotExist(user.getSecurityInformation().getUsername())) {
            user.getSecurityInformation().setPassword(passwordEncoder.encode(user.getSecurityInformation().getPassword()));
            userRepository.save(user);
        }
    }

    public void deleteUser(User user) {
        if(userDoesExist(user.getSecurityInformation().getUsername())) {
            userRepository.delete(user);
        }
    }

    public void updateUser(User user) {
        if(userDoesExist(user.getSecurityInformation().getUsername())) {
            userRepository.save(user);
        }
    }

    private boolean userDoesExist(String username) {
        return userRepository.findUserByUsername(username).isPresent();
    }

    private boolean userDoesNotExist(String username) {
        return userRepository.findUserByUsername(username).isEmpty();
    }
}
