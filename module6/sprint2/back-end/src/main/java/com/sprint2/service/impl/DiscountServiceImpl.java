package com.sprint2.service.impl;

import com.sprint2.repository.IDiscountRepository;
import com.sprint2.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements IDiscountService {
    @Autowired
    private IDiscountRepository iDiscountRepository;
}
