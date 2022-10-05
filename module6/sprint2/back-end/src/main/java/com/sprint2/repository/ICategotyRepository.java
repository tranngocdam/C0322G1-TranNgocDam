package com.sprint2.repository;

import com.sprint2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategotyRepository extends JpaRepository<Category, Integer> {
}
