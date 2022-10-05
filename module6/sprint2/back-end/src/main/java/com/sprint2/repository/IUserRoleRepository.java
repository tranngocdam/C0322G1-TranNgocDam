package com.sprint2.repository;

import com.sprint2.model.AppUsers;
import com.sprint2.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByAppUsers(AppUsers appUser);

    @Transactional
    @Modifying
    @Query(value = "delete from user_role where user_id= :id", nativeQuery = true)
    void deleteUserRole(@Param("id") int id);

    @Query(value = "select * from user_role", nativeQuery = true)
    List<UserRole> findAll();

    @Modifying
    @Query(value = "insert into user_role (is_delete, role_id, user_id) values (0, :roleId, :userId)", nativeQuery = true)
    void save(@Param("roleId") Integer roleId, @Param("userId") Integer userId);
}
