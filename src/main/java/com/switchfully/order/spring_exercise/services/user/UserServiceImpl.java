package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.user.User;
import com.switchfully.order.spring_exercise.domain.user.UserRole;
import com.switchfully.order.spring_exercise.exceptions.EntityCouldNotBeFoundExc;
import com.switchfully.order.spring_exercise.repositories.UserRepository;
import com.switchfully.order.spring_exercise.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final SecurityService securityService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(SecurityService securityService, UserRepository userRepository, UserMapper userMapper) {
        this.securityService = securityService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(CreateUserDto createUserDto) {
        User user = userMapper.convertDtoToUser(createUserDto);
        securityService.addUser(user);
        return new UserDto(user);
    }

    @Override
    public List<UserDto> getAllCustomers() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getSecurityInformation().getUserRole().equals(UserRole.CUSTOMER))
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getCustomerById(Long id) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getSecurityInformation().getUserRole().equals(UserRole.CUSTOMER))
                .filter(user -> user.getId().equals(id))
                .map(UserDto::new)
                .findFirst()
                .orElseThrow(() -> {
                    throw new EntityCouldNotBeFoundExc();
                });
    }
}
