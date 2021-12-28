package com.codev.services;

import com.codev.domain.User;

import java.util.List;

public interface IUserService {

    List<User> list(String code);
    User get(int id, String code);
    User get(int id);
    User create(User user);
    User update(int id, User user, String code);
    void delete(int id, String code);

}
