package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.exceptions.EntityCouldNotBeFoundExc;
import com.switchfully.order.spring_exercise.domain.user.User;
import com.switchfully.order.spring_exercise.domain.user.UserRole;
import com.switchfully.order.spring_exercise.repositories.user.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepositoryImpl userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(CreateUserDto createUserDto) {
        User user = userMapper.convertDtoToUser(createUserDto);
        userRepository.save(user);
        return new UserDto(user);
    }

    @Override
    public List<UserDto> getAllCustomers() {
      return userRepository.getAllUsers()
               .stream()
              .filter(user -> user.getUserRole().equals(UserRole.CUSTOMER))
               .map(UserDto::new)
               .collect(Collectors.toList());
    }

    @Override
    public UserDto getCustomerById(String id) {
        return userRepository.getAllUsers()
                .stream()
                .filter(user -> user.getUserRole().equals(UserRole.CUSTOMER))
                .filter(user -> user.getId().equals(id))
                .map(UserDto::new)
                .findFirst()
                .orElseThrow(() -> {throw new EntityCouldNotBeFoundExc();});
    }
}
