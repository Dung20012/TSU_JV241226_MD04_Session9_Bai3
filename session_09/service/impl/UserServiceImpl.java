package com.data.session_09.service.impl;

import com.data.session_09.model.entity.User;
import com.data.session_09.repository.IUserRepository;
import com.data.session_09.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void register(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username đã tồn tại");
        }
        userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
