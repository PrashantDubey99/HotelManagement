package com.pd.rating_service.repository;

import com.pd.rating_service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingDao extends JpaRepository<Rating, String> {
    public List<Rating> findByUserId(String userId);
    public List<Rating> findByHotelId(String hotelId);
}
