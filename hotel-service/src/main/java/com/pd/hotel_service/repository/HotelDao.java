package com.pd.hotel_service.repository;

import com.pd.hotel_service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelDao extends JpaRepository<Hotel, String> {
    List<Hotel> findByLocation(String location);

    Hotel findByName(String name);
}
