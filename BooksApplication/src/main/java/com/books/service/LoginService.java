package com.books.service;

import com.books.model.User;
import com.books.model.UserDTO;

public interface LoginService {
    User login(UserDTO userDTO);
}
