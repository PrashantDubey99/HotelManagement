package com.pd.hotel_service.service;

import com.pd.hotel_service.entities.Hotel;
import com.pd.hotel_service.repository.HotelDao;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {
    @Autowired
    HotelDao hotelDao;

    public Hotel addHotel(Hotel hotel) {
        String randomUserId = UUID.randomUUID().toString();
        hotel.setId(randomUserId);
        return hotelDao.save(hotel);
    }

    public Hotel getHotelById(String hotelId) {

        return hotelDao.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));
    }

    public List<Hotel> getAllHotels() {
        return hotelDao.findAll();
    }

    public Hotel deleteHotelById(String hotelId) {
        return hotelDao.findById(hotelId).orElseThrow( () -> new NotFoundException("Hotel not found with id: " + hotelId + ""));
    }

    public List<Hotel> getHotelByLocation(String location) {
        List<Hotel> hotels = hotelDao.findByLocation(location);
        if (hotels.isEmpty()) {
            throw new NotFoundException("Hotel not available with location: " + location + "");
        }
        return hotels;
    }

    public Hotel getHotelByName(String name) {
        Hotel hotel = hotelDao.findByName(name);
        if (hotel == null) {
            throw new NotFoundException("Hotel not available with name: " + name + "");
        }
        return hotel;
    }
}
