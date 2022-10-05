package com.sprint2.service.impl;

import com.sprint2.repository.IOrderBookRepository;
import com.sprint2.service.IOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookServiceImpl implements IOrderBookService {
    @Autowired
    private IOrderBookRepository iOrderBookRepository;
}
