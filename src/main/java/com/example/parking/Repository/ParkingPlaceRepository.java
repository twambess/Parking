package com.example.parking.Repository;

import com.example.parking.Entity.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace,Long> {


}
