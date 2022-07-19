package com.codegym.exam.service;

import com.codegym.exam.model.Contract;
import com.codegym.exam.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);

    void delete(String contractCode);

    Contract findById(String contractCode);
}
