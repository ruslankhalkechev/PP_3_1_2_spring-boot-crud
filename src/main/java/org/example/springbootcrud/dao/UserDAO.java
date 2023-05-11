package org.example.springbootcrud.dao;


import org.example.springbootcrud.model.User;

import java.util.List;

public interface UserDAO {
    User add(User user);

    void deleteUserById(long id);

    User update(User user);

    User getUserById(long id);

    List<User> getListOfUsers();
}
