package com.greenfox.fedex.service;

import com.greenfox.fedex.model.Result;
import com.greenfox.fedex.model.User;
import com.greenfox.fedex.repository.ResultsRepository;
import com.greenfox.fedex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

  private UserRepository userRepository;
  private ResultsRepository resultsRepository;

  @Autowired
  public UserService(UserRepository userRepository, ResultsRepository resultsRepository) {
    this.userRepository = userRepository;
    this.resultsRepository = resultsRepository;
  }

  public Page<Result> findBestTimes() {
    for (int i = 0; i < 100; ++i) {
      userRepository.save(new User(
              "John" + i,
              "54" + i,
              "52" + i,
              "https://static.comicvine.com/uploads/original/11111/111115170/3445548-4383058771-Avata.jpg",
              "#20D1AC"));
    }
    for (int i = 0; i < 100; ++i) {
      String nickName = "John" + i;
      resultsRepository.save(new Result(nickName, new Date(System.currentTimeMillis()), 54 + i, 65 - i, 54 - i * 2, 93 + i * 3, userRepository.findOne(nickName).getAvatar()));
    }
    return resultsRepository.findAllByOrderBySpinTimeDesc(new PageRequest(0, 10));
  }

  public Page<Result> findBestNumberOfSpins() {
    return resultsRepository.findAllByOrderByNumberOfSpinsDesc(new PageRequest(0, 10));
  }

  public Page<Result> findBestAvgRpms() {
    return resultsRepository.findAllByOrderByAvgRpmDesc(new PageRequest(0, 10));
  }

  public Page<Result> findBestMaxRpms() {
    return resultsRepository.findAllByOrderByMaxRpmDesc(new PageRequest(0, 10));
  }
}
