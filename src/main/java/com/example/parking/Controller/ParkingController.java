package com.example.parking.Controller;

import com.example.parking.Entity.Car;
import com.example.parking.Entity.ParkingPlace;
import com.example.parking.Repository.CarRepository;
import com.example.parking.Repository.ParkingPlaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
public class ParkingController {
   private final ParkingPlaceRepository parkingPlaceRepository;
   public ParkingController(ParkingPlaceRepository parkingPlaceRepository){
       this.parkingPlaceRepository=parkingPlaceRepository;
   }
   @GetMapping("/")
    public List<ParkingPlace> getParking(){
       return parkingPlaceRepository.findAll();
   }

   @PostMapping("/item")
   public void addParking(@RequestBody ParkingPlace parkingPlace){
       parkingPlaceRepository.save(parkingPlace);
   }

   @DeleteMapping("/item/{parkingId}")
    public void deleteParking(@PathVariable("parkingId") Long id){
       parkingPlaceRepository.deleteById(id);
   }
}
