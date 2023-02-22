package com.example.parking.Controller;

import com.example.parking.Entity.Car;
import com.example.parking.Repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class CarQueryController {
    private final CarRepository carRepository;

    @QueryMapping
    Iterable<Car> cars(){
        return carRepository.findAll();
    }
}
