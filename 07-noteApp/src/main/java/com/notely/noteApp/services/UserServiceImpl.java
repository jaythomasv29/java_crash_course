package com.notely.noteApp.services;

import com.notely.noteApp.dtos.UserDto;
import com.notely.noteApp.entities.User;
import com.notely.noteApp.exceptions.UserNotFoundException;
import com.notely.noteApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public User saveUser(UserDto userDto) {
   return userRepository.saveAndFlush(new User(userDto));
  }

  @Override
  public User loginUser(UserDto userDto) {
    Optional<User> wrappedUser = userRepository.findByUsername(userDto.getUsername());
    // if user is present, then check password
    User user = unwrapUser(wrappedUser);
      if(passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
        // successful validation returns the appropriate user
        return user;
    }
      throw new RuntimeException("authentication failed");
  }

  public static User unwrapUser(Optional<User> wrappedUser) {
    if(wrappedUser.isPresent()) {
      return wrappedUser.get();
    }
    throw new UserNotFoundException();
  }
}


