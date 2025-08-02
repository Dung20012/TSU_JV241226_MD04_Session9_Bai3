package com.data.session_09.repository;

import com.data.session_09.model.entity.User;

public interface IUserRepository {
    void save(User user);
    User findByUsername(String username);
}
