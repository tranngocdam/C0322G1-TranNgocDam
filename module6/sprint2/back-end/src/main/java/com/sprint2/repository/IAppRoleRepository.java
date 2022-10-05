package com.sprint2.repository;

import com.sprint2.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole, Integer> {
}
