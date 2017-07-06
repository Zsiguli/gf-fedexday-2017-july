package com.greenfox.fedex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "results")
public class Result {

  private String nickName;
  private Data time;
  private Integer spinTime;
  private Integer numberOfSpins;
  private Integer AVG_RPM;
  private Integer MAX_RPM;
}
