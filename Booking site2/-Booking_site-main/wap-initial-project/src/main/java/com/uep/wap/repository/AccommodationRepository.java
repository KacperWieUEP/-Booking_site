package com.uep.wap.repository;

import com.uep.wap.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findByCountryAndCityAndPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
            String country, String city, double minPrice, double maxPrice, int minRooms);

    List<Accommodation> findByCountryAndPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
            String country, double minPrice, double maxPrice, int minRooms);

    List<Accommodation> findByCityAndPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
            String city, double minPrice, double maxPrice, int minRooms);

    List<Accommodation> findByPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
            double minPrice, double maxPrice, int minRooms);
}
