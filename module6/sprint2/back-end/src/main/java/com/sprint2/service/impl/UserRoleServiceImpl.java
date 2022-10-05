package com.sprint2.service.impl;

import com.sprint2.model.UserRole;
import com.sprint2.repository.IAppUsersRepository;
import com.sprint2.repository.IUserRoleRepository;
import com.sprint2.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Autowired
    private IAppUsersRepository iAppUsersRepository;
    @Override
    public List<UserRole> findAll() {
        return iUserRoleRepository.findAll();
    }

    @Override
    public void save(UserRole userRole) {
        iUserRoleRepository.save(userRole.getAppRole().getId(), userRole.getAppUsers().getId());
    }

    @Override
    public void deleteUserRole(int id) {
        iUserRoleRepository.deleteUserRole(id);
    }
}
