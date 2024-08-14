package com.neueda.payments.service;


import com.neueda.payments.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);

    User findById(Long id);
}
