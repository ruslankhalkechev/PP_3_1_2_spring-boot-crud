package org.example.springbootcrud.service;

import org.example.springbootcrud.dao.UserDAO;
import org.example.springbootcrud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public User add(User user) {
        userDAO.add(user);
        return user;
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    @Transactional
    public User update(User updatedUser, long id) {
        User userToBeUpdated = getUserById(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setSalary(updatedUser.getSalary());

        userDAO.update(userToBeUpdated);
        return userToBeUpdated;
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getListOfUsers() {
        return userDAO.getListOfUsers();
    }
}