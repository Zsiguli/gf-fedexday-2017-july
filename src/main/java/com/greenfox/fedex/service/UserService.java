package com.greenfox.fedex.service;

import com.greenfox.fedex.model.User;
import com.greenfox.fedex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Page<User> findAllTheUsers() {
    return userRepository.findAll(new PageRequest(0, 100));
  }
}
