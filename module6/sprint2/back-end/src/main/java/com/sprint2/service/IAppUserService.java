package com.sprint2.service;

import com.sprint2.model.AppUsers;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

public interface IAppUserService {

    AppUsers findByName(String name);

    String existsByUserName(String username) throws MessagingException, UnsupportedEncodingException;

    void saveNewPassword(String password, String name);

    List<AppUsers> findAll();

    void save(AppUsers appUsers);

    Optional<AppUsers> findById(Integer id);

    void edit(AppUsers appUsers);

    void deleteUser(int id);

    Boolean existsUsername(String username);
}
