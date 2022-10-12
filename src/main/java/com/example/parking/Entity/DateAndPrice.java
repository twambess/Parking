package com.example.parking.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="DATE_AND_PRICE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DateAndPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="carId")
    private  Car car;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_place_id")
    private ParkingPlace parkingPlace;

    @Column(name="date")
    private Date date;

    @Column(name = "price")
    private Double price;
}
