package com.service.impl;

import com.service.IService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements IService {

    @Override
    public double currency(double a, double b) {
        return a*b;
    }
}
