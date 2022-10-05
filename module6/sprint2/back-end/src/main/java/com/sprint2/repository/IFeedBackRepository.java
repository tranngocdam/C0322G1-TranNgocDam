package com.sprint2.repository;

import com.sprint2.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer> {
}
