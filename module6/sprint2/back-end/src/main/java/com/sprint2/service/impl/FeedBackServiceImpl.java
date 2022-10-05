package com.sprint2.service.impl;

import com.sprint2.repository.IFeedBackRepository;
import com.sprint2.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements IFeedbackService {
    @Autowired
    private IFeedBackRepository iFeedBackRepository;
}
