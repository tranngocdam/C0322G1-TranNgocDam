package com.sprint2.service.impl;

import com.sprint2.model.AppRole;
import com.sprint2.repository.IAppRoleRepository;
import com.sprint2.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImpl implements IAppRoleService {
    @Autowired
    private IAppRoleRepository iAppRoleRepository;
    @Override
    public List<AppRole> findAllAppRole() {
        return iAppRoleRepository.findAll();
    }
}
