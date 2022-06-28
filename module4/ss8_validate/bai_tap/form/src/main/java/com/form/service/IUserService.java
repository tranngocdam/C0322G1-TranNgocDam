package com.form.service;

import com.form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IUserService {
    List<User> findAll();

    void saveOrUpdate(User user);

    void delete(User user);

    User findById(Integer id);
}
