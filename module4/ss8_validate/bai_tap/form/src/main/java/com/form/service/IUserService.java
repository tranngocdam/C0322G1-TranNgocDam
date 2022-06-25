package com.form.service;

import com.form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IUserService {
    Page<User> findAll(Pageable pageable);

    void saveOrUpdate(User user);

    void delete(User user);

    User findById(Integer id);
}
