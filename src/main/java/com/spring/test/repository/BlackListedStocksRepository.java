package com.spring.test.repository;

import com.spring.test.model.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListedStocksRepository extends JpaRepository<BlackList, String> {
}
