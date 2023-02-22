package com.example.parking.Controller;

import com.example.parking.Entity.DateAndPrice;
import com.example.parking.Repository.DateAndPriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class DateAndPriceQueryController {
    private final DateAndPriceRepository dateAndPriceRepository;

    @QueryMapping
    Iterable<DateAndPrice> dates() {
        return dateAndPriceRepository.findAll();
    }
}
