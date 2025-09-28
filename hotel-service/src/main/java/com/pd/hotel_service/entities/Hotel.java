package com.pd.hotel_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HOTELS")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
