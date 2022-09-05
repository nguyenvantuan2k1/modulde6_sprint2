package com.example.beclothesshop.repositories;

import com.example.beclothesshop.model.entity.Rates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rates, Long> {

//    @Query(value = "insert into rates(comment, date_rate, start, product_id, user_id) values(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
//    void saveRate(String comment, Date date, Double start, long productId, long userId);
}
