package com.notely.noteApp.services;

import com.notely.noteApp.dtos.UserDto;
import com.notely.noteApp.entities.User;

import javax.transaction.Transactional;

public interface UserService {
  @Transactional
  User saveUser(UserDto userDto);

  User loginUser(UserDto userDto);
}
