package com.spring.test.repository;

import com.spring.test.model.TradeData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<TradeData, Long> {

    @Query("SELECT t FROM TradeData t WHERE brokerCode = :broker")
    List<TradeData> findAllBrokers(@Param("broker") String broker);

    @Query("SELECT stockName FROM TradeData t GROUP BY stockName ORDER BY SUM(quantity) DESC")
    List<String> findTop5Stocks(Pageable page);

}


