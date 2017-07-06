package com.greenfox.fedex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  private String nickname;
  private String email;
  private String password;
  private String avatar;
  private String backgroundColor;
}
