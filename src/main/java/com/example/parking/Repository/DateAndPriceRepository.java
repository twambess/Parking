package com.example.parking.Repository;

import com.example.parking.Entity.DateAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface DateAndPriceRepository extends JpaRepository<DateAndPrice,Long> {

    Optional<DateAndPrice> findByPrice(Double price);
    Optional<DateAndPrice> findByDate(Date date);
}
