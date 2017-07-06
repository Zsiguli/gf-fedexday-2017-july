package com.greenfox.fedex.model;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
public class Data {

  public Page<Result> page;
  public Links links;
}
