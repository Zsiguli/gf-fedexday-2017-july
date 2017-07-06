package com.greenfox.fedex.model;

import lombok.Getter;

@Getter
public class Ok {
  private String status;

  public Ok() {
    status = "ok";
  }
}
