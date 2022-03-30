package com.persistence;

import com.model.User;

import java.util.Optional;

public interface UserRepo {
    Optional<User> getByUsername(String username) throws Exception;
}
