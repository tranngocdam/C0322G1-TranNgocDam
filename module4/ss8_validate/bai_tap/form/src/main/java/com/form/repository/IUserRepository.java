package com.form.repository;

import com.form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
//    @Query(value = " select *  from user ", nativeQuery = true)
//    List<User> findAll();
//
//    @Query(value = " select * from user u where u.id = :id", nativeQuery = true)
//    User findById(@Param("id") int id);
}
