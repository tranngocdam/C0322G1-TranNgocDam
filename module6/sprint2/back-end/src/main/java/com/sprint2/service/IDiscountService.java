package com.sprint2.service;

import com.sprint2.model.Discount;

import java.util.List;

public interface IDiscountService {

    List<Discount> findAllDiscount();

    Discount findById(Integer id);
}
