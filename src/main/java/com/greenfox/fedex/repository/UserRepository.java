package com.greenfox.fedex.repository;

import com.greenfox.fedex.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
}
