package com.example.parking.Controller;

import com.example.parking.Entity.Car;
import com.example.parking.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final
    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @GetMapping("/names/{name}")
    public Optional<Car> getByName(@PathVariable String name){
        return carRepository.findByName(name);
    }

    @PostMapping("/item")
    public void addCar(@RequestBody Car car){
        carRepository.save(car);

    }

    @DeleteMapping("/item/{carId}")
    public void deleteCar(@PathVariable("carId") Long carId){
        carRepository.deleteById(carId);
    }

    @PutMapping("/item")
    public void update(@RequestBody Car car){
        Optional<Car> row=carRepository.findById(car.getId());
        if(row.isPresent()){
            Car item=row.get();
            if(!car.getName().isEmpty()){
                item.setName(car.getName());
            }
            carRepository.save(item);
        }


    }
}
