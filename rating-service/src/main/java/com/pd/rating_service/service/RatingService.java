package com.pd.rating_service.service;

import com.pd.rating_service.entities.Rating;
import com.pd.rating_service.repository.RatingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {
    @Autowired
    RatingDao ratingDao;

    public Rating addRating(Rating rating) {
        String randomUserId = UUID.randomUUID().toString();
        rating.setRatingId(randomUserId);
        return ratingDao.save(rating);
    }

    public List<Rating> getRatingAll() {
        return ratingDao.findAll();
    }

    public List<Rating> getRatingByUserId(String userId) {
        return ratingDao.findByUserId(userId);
    }

    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingDao.findByHotelId(hotelId);
    }
}
