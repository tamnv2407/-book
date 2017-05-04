package com.books.repository;

import com.books.model.User;

public interface UserRepository {

	User getUserByEmail(String email);

}
