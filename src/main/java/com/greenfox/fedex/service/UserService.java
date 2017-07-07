package com.greenfox.fedex.service;

import com.greenfox.fedex.model.*;
import com.greenfox.fedex.repository.ResultsRepository;
import com.greenfox.fedex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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

  public User findUser(String nickName) {
    return userRepository.findOne(nickName);
  }

  public Ok createUser(User newUser) {
    userRepository.save(newUser);
    return new Ok();
  }

  public Ok updateUser(User newProperties) {
    User userToUpdate = userRepository.findOne(newProperties.getNickName());
    userToUpdate.setAvatar(newProperties.getAvatar());
    userToUpdate.setBackgroundColor(newProperties.getBackgroundColor());
    userRepository.save(userToUpdate);
    return new Ok();
  }

  public Data returnBests(Integer page, List<String> properties, HttpServletRequest request) {
    Page<Result> bests = findBestByParameters(page, properties);
    Links links = generateLinks(page, bests, request);
    return new Data(bests, links);
  }

  private Page<Result> findBestByParameters(Integer page, List<String> properties) {
    return resultsRepository.findAll(new PageRequest(page, 10, new Sort(Sort.Direction.DESC, properties)));
  }

  private Links generateLinks(Integer page, Page<Result> bests, HttpServletRequest request) {
    StringBuffer requestURL = request
            .getRequestURL()
            .append("?");
    String queryString = request.getQueryString();
    Links links = new Links(requestURL
            .toString()
            + request.getQueryString());
    if (bests.hasNext()) {
      links.setNext(requestURL.toString() + queryString.replaceAll(page.toString(), "" + (page + 1)));
    }
    if (bests.hasPrevious()) {
      links.setPrev(requestURL.toString() + queryString.replaceAll(page.toString(), "" + (page - 1)));
    }
    return links;
  }
}
