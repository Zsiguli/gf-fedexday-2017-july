package com.greenfox.fedex.service;

import com.greenfox.fedex.model.User;
import com.greenfox.fedex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Page<User> findAllTheUsers() {
    for (int i = 0; i < 100; ++i) {
      userRepository.save(new User("John" + i, "54" + i, "52" + i));
    }
    return userRepository.findAll(new PageRequest(0, 20));
  }
}
