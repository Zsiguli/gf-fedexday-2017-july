package com.greenfox.fedex.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Getter
@Setter
@Entity
public class User {

  @Id
  private String name;
  private String bestSpeed;
  private String bestTime;
}
