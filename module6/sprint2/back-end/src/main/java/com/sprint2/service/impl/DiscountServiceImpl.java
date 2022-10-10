package com.sprint2.service.impl;

import com.sprint2.model.Discount;
import com.sprint2.repository.IDiscountRepository;
import com.sprint2.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements IDiscountService {
    @Autowired
    private IDiscountRepository iDiscountRepository;

    @Override
    public List<Discount> findAllDiscount() {
        return iDiscountRepository.findAllDiscount();
    }

    @Override
    public Discount findById(Integer id) {
        return iDiscountRepository.findByIdDiscount(id);
    }
}
