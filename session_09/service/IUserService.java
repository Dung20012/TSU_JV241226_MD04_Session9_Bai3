package com.data.session_09.service;

import com.data.session_09.model.entity.User;

public interface IUserService {
    void register(User user);
    User login(String username, String password);
}
