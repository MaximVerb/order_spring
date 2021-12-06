package com.switchfully.order.spring_exercise.services.user;

import com.switchfully.order.spring_exercise.domain.User;
import com.switchfully.order.spring_exercise.repositories.user.UserRepositoryImpl;
import com.switchfully.order.spring_exercise.services.dtos.user.CreateUserDto;
import com.switchfully.order.spring_exercise.services.dtos.user.UserDto;
import com.switchfully.order.spring_exercise.services.mappers.user.UserMapper;
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
    public List<UserDto> getAllUsers() {
      return userRepository.getAllUsers()
               .stream()
               .map(UserDto::new)
               .collect(Collectors.toList());
    }
}
