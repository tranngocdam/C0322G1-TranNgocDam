package com.form.service;

import com.form.model.User;
import com.form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return iUserRepository.findAll(pageable);
    }

    @Override
    public void saveOrUpdate(User user) {
        iUserRepository.save(user);
    }

    @Override
    public void delete(User user) {
        iUserRepository.delete(user);
    }

    @Override
    public User findById(Integer id) {
        return iUserRepository.findById(id).orElse(null);
    }
}
