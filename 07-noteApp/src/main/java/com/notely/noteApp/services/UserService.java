package com.notely.noteApp.services;

import com.notely.noteApp.dtos.UserDto;
import com.notely.noteApp.entities.User;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

public interface UserService {
  @Transactional
  User saveUser(UserDto userDto);

  @Transactional
  User loginUser(UserDto userDto);
}
