package com.codev.services;

import com.codev.domain.User;

import java.util.List;

public interface IUserService {

    List<User> list();
    User get(int id);
    User create(User user);
    User update(int id, User user);
    void delete(int id);

}
