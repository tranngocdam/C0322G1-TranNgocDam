package com.sprint2.service;

import com.sprint2.model.UserRole;

import java.util.List;

public interface IUserRoleService {

    List<UserRole> findAll();

    void save(UserRole userRole);

    void deleteUserRole(int id);
}
