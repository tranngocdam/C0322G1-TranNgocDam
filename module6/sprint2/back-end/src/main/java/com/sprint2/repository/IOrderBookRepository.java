package com.sprint2.repository;

import com.sprint2.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderBookRepository extends JpaRepository<OrderBook, Integer> {
}
