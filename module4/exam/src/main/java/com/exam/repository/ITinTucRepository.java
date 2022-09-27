package com.exam.repository;

import com.exam.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITinTucRepository extends JpaRepository<TinTuc, Integer> {
    @Query(value="select * from tintuc where tieu_de like :tieuDe",nativeQuery=true)
    List<TinTuc> findByTieuDe(@Param("tieuDe") String tieuDe);
}
