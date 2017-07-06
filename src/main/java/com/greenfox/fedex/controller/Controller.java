package com.greenfox.fedex.controller;

import com.greenfox.fedex.model.Data;
import com.greenfox.fedex.model.Links;
import com.greenfox.fedex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

  private UserService userService;

  @Autowired
  public Controller (UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping("/api/users")
  public Data returnAllTheUsers(HttpServletRequest request) {
    Links links = new Links(request.getRequestURL().toString());
    links.setNext("next");
    links.setPrev("prev");
    links.setLast("last");
    System.out.println(links.getSelf());
    return new Data(userService.findAllTheUsers(), links);
  }
}
