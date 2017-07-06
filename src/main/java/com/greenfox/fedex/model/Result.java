package com.greenfox.fedex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "results")
public class Result {

  @Id
  private String nickName;
  private Date time;
  private Integer spinTime;
  private Integer numberOfSpins;
  private Integer avgRpm;
  private Integer maxRpm;
  private String avatar;
}
