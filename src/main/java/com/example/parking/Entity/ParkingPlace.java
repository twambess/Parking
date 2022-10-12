package com.example.parking.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="PARKING_PLACE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@AllArgsConstructor
public class ParkingPlace {

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy ="parkingPlace")
    private DateAndPrice dateAndPrice;




}
