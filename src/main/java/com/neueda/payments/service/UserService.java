package com.neueda.payments.service;


import com.neueda.payments.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User save(User user);

    User getById(Long id);
}
