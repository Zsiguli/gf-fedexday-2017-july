package com.greenfox.fedex.controller;

import com.greenfox.fedex.model.Data;
import com.greenfox.fedex.model.Links;
import com.greenfox.fedex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
public class Controller {

  private UserService userService;

  @Autowired
  public Controller (UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping("/api/best_times")
  public Data bestTimes(HttpServletRequest request) {
    Links links = new Links(request.getRequestURL().toString());
    links.setNext("next");
    links.setPrev("prev");
    links.setLast("last");
    return new Data(userService.findBestTimes(), links);
  }

  @GetMapping("/api/best_no_spins")
  public Data bestNumberOfSpins(HttpServletRequest request) {
    Links links = new Links(request.getRequestURL().toString());
    links.setNext("next");
    links.setPrev("prev");
    links.setLast("last");
    return new Data(userService.findBestNumberOfSpins(), links);
  }

  @GetMapping("/api/best_avg_rpms")
  public Data bestAvgRpms(HttpServletRequest request) {
    Links links = new Links(request.getRequestURL().toString());
    links.setNext("next");
    links.setPrev("prev");
    links.setLast("last");
    return new Data(userService.findBestAvgRpms(), links);
  }

  @GetMapping("/api/best_max_rpms")
  public Data bestMaxRpms(HttpServletRequest request) {
    Links links = new Links(request.getRequestURL().toString());
    links.setNext("next");
    links.setPrev("prev");
    links.setLast("last");
    return new Data(userService.findBestMaxRpms(), links);
  }
}
