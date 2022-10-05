package com.sprint2.service.impl;

import com.sprint2.repository.ICustomerRepository;
import com.sprint2.service.ICutomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICutomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
}
