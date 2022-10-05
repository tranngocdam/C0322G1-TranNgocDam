package com.sprint2.repository;

import com.sprint2.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IAppUsersRepository extends JpaRepository<AppUsers, Integer> {
    @Query(value = "select * from app_users a where a.username = :name and is_delete = 0", nativeQuery = true)
    AppUsers findAppUserByName(@Param("name") String name);

    @Query(value = "SELECT username from app_users where username = ?1 and is_delete = 0", nativeQuery = true)
    String existsByUserName(String username);

    @Modifying
    @Query(value = "update app_users set password =?1 where username = ?2", nativeQuery = true)
    void saveNewPassword(String password, String name);

    @Transactional
    @Modifying
    @Query(value = "update app_users set is_delete = 1 where id = :id", nativeQuery = true)
    void deleteUser(@Param("id") int id);

    @Query(value = "select * from app_users", nativeQuery = true)
    List<AppUsers> findAll();

    @Modifying
    @Query(value = "insert into app_users (username, `password`, creation_date, is_delete) values (:username, :password, current_date(), 0)", nativeQuery = true)
    void save(@Param("username") String username, @Param("password") String password);

    @Query(value = "select * from app_users where id = :id", nativeQuery = true)
    Optional<AppUsers> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update app_users set username = :username, `password` = :password where id = :id", nativeQuery = true)
    void edit(@Param("username") String username, @Param("password") String password, @Param("id") Integer id);

    @Query(value = "select username from app_users where username = :username", nativeQuery = true)
    String existsUsername(@Param("username") String username);
}
