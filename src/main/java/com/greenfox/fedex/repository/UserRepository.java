package com.greenfox.fedex.repository;

import com.greenfox.fedex.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
