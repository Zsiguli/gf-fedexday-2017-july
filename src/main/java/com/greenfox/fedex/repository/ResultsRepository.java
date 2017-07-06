package com.greenfox.fedex.repository;

import com.greenfox.fedex.model.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResultsRepository extends PagingAndSortingRepository<Result, String> {
  Page<Result> findAllByOrderBySpinTimeDesc(Pageable pageable);
  Page<Result> findAllByOrderByNumberOfSpinsDesc(Pageable pageable);
  Page<Result> findAllByOrderByAvgRpmDesc(Pageable pageable);
  Page<Result> findAllByOrderByMaxRpmDesc(Pageable pageable);
}
