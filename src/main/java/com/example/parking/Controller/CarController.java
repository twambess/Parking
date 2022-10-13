package com.example.parking.Controller;

import com.example.parking.Entity.Car;
import com.example.parking.Repository.CarRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@Api("Контроллер клиентских объектов 'car'")
public class CarController {
    private final
    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    @ApiOperation("Получение списка всех машин")
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @GetMapping("/names/{name}")
    @ApiOperation("Получение списка машин по имени владельца")
    public Optional<Car> getByName(@PathVariable String name){
        return carRepository.findByName(name);
    }

    @PostMapping("/item")
    @ApiOperation("Создание новой машины")
    public void addCar(@RequestBody Car car){
        carRepository.save(car);

    }

    @DeleteMapping("/item/{carId}")
    @ApiOperation("Удаление машины по id")
    public void deleteCar(@PathVariable("carId") Long carId){
        carRepository.deleteById(carId);
    }

    @PutMapping("/item")
    @ApiOperation("Изменение существующей машины")
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
