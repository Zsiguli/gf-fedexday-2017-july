package com.greenfox.fedex.controller;

import com.greenfox.fedex.model.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @GetMapping("/users")
  public Page<User> returnAllTheUsers() {
    return userService.findAll();
  }
}
