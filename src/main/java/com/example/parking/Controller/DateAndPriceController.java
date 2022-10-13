package com.example.parking.Controller;

import com.example.parking.Entity.DateAndPrice;
import com.example.parking.Repository.DateAndPriceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("date_and_price")
@Api("Контроллер дат и цен")
public class DateAndPriceController {
    private final DateAndPriceRepository dateAndPriceRepository;

    public DateAndPriceController(DateAndPriceRepository dateAndPriceRepository) {
        this.dateAndPriceRepository = dateAndPriceRepository;
    }

    @GetMapping("/")
    @ApiOperation("Получение всех записей")
    public List<DateAndPrice> list(){
        return dateAndPriceRepository.findAll();
    }

    @PostMapping("/item")
    @ApiOperation("Создание новой записи")
    public void addClient(@RequestBody DateAndPrice dateAndPrice){
        dateAndPriceRepository.save(dateAndPrice);
    }

    @DeleteMapping("/item/{dateId}")
    @ApiOperation("Удаление записи по айди")
    public void deleteClient(@PathVariable("dateId") Long id){
        dateAndPriceRepository.deleteById(id);
    }

    @DeleteMapping("/item")
    @ApiOperation("Удаление всех записей")
    public void deleteAllClient(){
        dateAndPriceRepository.deleteAll();
    }

    @PutMapping("/item")
    @ApiOperation("Редактирование записи")
    public void update(@RequestBody DateAndPrice dateAndPrice){
        Optional<DateAndPrice> row=dateAndPriceRepository.findById(dateAndPrice.getId());
        if(row.isPresent()){
            DateAndPrice item=row.get();
            if(dateAndPrice.getPrice()!=null){
                item.setPrice(dateAndPrice.getPrice());
            }
            if(dateAndPrice.getDate()!=null){
                item.setDate(dateAndPrice.getDate());
            }
            if(dateAndPrice.getCar()!=null){
                item.setCar(dateAndPrice.getCar());
            }
            if(dateAndPrice.getParkingPlace()!=null){
                item.setParkingPlace(dateAndPrice.getParkingPlace());
            }
            dateAndPriceRepository.save(item);
        }
    }
    @ApiOperation("Получение записи по цене")
    @GetMapping("/values/{price}")
    public Optional<DateAndPrice> getByPrice(@PathVariable(name="price") Double price){
        return dateAndPriceRepository.findByPrice(price);
    }

    @GetMapping("/{id}")
    @ApiOperation("Получение записи по id")
    public Optional<DateAndPrice> getById(@PathVariable(name="id") Long id){
        return dateAndPriceRepository.findById(id);
    }


}
