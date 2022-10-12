package com.example.parking.Controller;

import com.example.parking.Entity.DateAndPrice;
import com.example.parking.Repository.DateAndPriceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("date_and_price")
public class DateAndPriceController {
    private final DateAndPriceRepository dateAndPriceRepository;

    public DateAndPriceController(DateAndPriceRepository dateAndPriceRepository) {
        this.dateAndPriceRepository = dateAndPriceRepository;
    }

    @GetMapping("/")
    public List<DateAndPrice> list(){
        return dateAndPriceRepository.findAll();
    }

    @PostMapping("/item")
    public void addClient(@RequestBody DateAndPrice dateAndPrice){
        dateAndPriceRepository.save(dateAndPrice);
    }

    @DeleteMapping("/item/{dateId}")
    public void deleteClient(@PathVariable("dateId") Long id){
        dateAndPriceRepository.deleteById(id);
    }

    @PutMapping("/item")
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
    @GetMapping("/values/{price}")
    public Optional<DateAndPrice> getByPrice(@PathVariable(name="price") Double price){
        return dateAndPriceRepository.findByPrice(price);
    }

    @GetMapping("/{id}")
    public Optional<DateAndPrice> getById(@PathVariable(name="id") Long id){
        return dateAndPriceRepository.findById(id);
    }

    @GetMapping("/dates/{date}")
    public Optional<DateAndPrice> getByDate(@PathVariable(name="date") Date date){
        return dateAndPriceRepository.findByDate(date);
    }




}
