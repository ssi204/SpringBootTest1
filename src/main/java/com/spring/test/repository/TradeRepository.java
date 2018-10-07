package com.spring.test.repository;

import com.spring.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface TradeRepository extends JpaRepository<User, Long> {
}
