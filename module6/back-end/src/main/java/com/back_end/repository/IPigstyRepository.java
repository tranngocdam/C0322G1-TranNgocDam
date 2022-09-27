package com.back_end.repository;

import com.back_end.model.Pigsty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPigstyRepository extends JpaRepository<Pigsty, Integer> {
    @Query(value="select * from pigsty", nativeQuery=true)
    Pigsty findAllPigsty();
}
