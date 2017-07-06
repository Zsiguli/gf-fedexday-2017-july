package com.greenfox.fedex.controller;

import com.greenfox.fedex.model.Data;
import com.greenfox.fedex.model.Links;
import com.greenfox.fedex.model.Ok;
import com.greenfox.fedex.model.User;
import com.greenfox.fedex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Controller {

  private UserService userService;

  @Autowired
  public Controller(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{nickName}")
  public User singleUser(@PathVariable String nickName) {
    return userService.findUser(nickName);
  }

  @PostMapping("/user")
  public Ok createNewUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PatchMapping("/user")
  public Ok updateUser(@RequestBody User newProperties) {
    return userService.updateUser(newProperties);
  }

  @GetMapping("/api/bests")
  public Data bestsByParameter(@RequestParam List<String> properties, HttpServletRequest request) {
    Links links = new Links(request.getRequestURL().toString());
    links.setNext("next");
    links.setPrev("prev");
    links.setLast("last");
    return new Data(userService.findBestByParameters(properties), links);
  }
}
