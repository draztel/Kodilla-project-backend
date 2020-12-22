package com.kodilla.project.service;

import com.kodilla.project.domain.User;
import com.kodilla.project.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDbService {
    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public Optional<User> getUser(final Long id) {
       return userDao.findById(id);
    }

    public User saveUser(final User user) {
        return userDao.save(user);
    }

    public void deleteUser(final Long id) {
        userDao.deleteById(id);
    }
}
