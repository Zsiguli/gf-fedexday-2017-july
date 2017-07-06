package com.greenfox.fedex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Links {
  private String self;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String next;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String prev;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String last;

  public Links(String self) {
    this.self = self;
  }
}
