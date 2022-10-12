package com.example.parking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="CAR")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "car", cascade =CascadeType.ALL)
    private DateAndPrice dateAndPrice;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="parking_place_id")
//    private ParkingPlace parkingId;
}

