package com.greenfox.fedex.controller;

import com.greenfox.fedex.model.User;
import com.greenfox.fedex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private UserService userService;

  @Autowired
  public Controller (UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping("/users")
  public Page<User> returnAllTheUsers() {
    return userService.findAllTheUsers();
  }
}
