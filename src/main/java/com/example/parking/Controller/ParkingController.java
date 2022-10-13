package com.example.parking.Controller;

import com.example.parking.Entity.ParkingPlace;
import com.example.parking.Repository.ParkingPlaceRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api("Контроллер парковочных мест")
public class ParkingController {
   private final ParkingPlaceRepository parkingPlaceRepository;
   public ParkingController(ParkingPlaceRepository parkingPlaceRepository){
       this.parkingPlaceRepository=parkingPlaceRepository;
   }

   @GetMapping("/")
   @ApiOperation("Получение парковочных мест")
    public List<ParkingPlace> getParking(){
       return parkingPlaceRepository.findAll();
   }

   @PostMapping("/item")
   @ApiOperation("Создание парковочного места")
   public void addParking(@RequestBody ParkingPlace parkingPlace){
       parkingPlaceRepository.save(parkingPlace);
   }

   @DeleteMapping("/item/{parkingId}")
   @ApiOperation("Удаление парковочного места по id")
    public void deleteParking(@PathVariable("parkingId") Long id){
       parkingPlaceRepository.deleteById(id);
   }

   @DeleteMapping("/item")
   @ApiOperation("Удаление всех парковочных мест")
   public void deleteAllParking(){
       parkingPlaceRepository.deleteAll();
   }
}
