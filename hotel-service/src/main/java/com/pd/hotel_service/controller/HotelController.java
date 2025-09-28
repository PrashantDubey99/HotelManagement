package com.pd.hotel_service.controller;

import com.pd.hotel_service.entities.Hotel;
import com.pd.hotel_service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelService.addHotel(hotel));
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteHotelById(@PathVariable String hotelId) {
        return ResponseEntity.ok(hotelService.deleteHotelById(hotelId));
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Hotel>> getHotelByLocation(@PathVariable String location) {
        return ResponseEntity.ok(hotelService.getHotelByLocation(location));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Hotel> getHotelByName(@PathVariable String name) {
        return ResponseEntity.ok(hotelService.getHotelByName(name));
    }
}
