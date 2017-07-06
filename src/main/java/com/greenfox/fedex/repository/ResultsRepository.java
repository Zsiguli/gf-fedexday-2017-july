package com.greenfox.fedex.repository;

import com.greenfox.fedex.model.Result;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResultsRepository extends PagingAndSortingRepository<Result, String> {
}
