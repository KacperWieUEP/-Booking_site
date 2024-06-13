package com.uep.wap.service;

import com.uep.wap.model.Accommodation;
import com.uep.wap.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;

    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    public Optional<Accommodation> getAccommodationById(Long id) {
        return accommodationRepository.findById(id);
    }

    public Accommodation saveAccommodation(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    public void deleteAccommodation(Long id) {
        accommodationRepository.deleteById(id);
    }

    public List<Accommodation> filterAccommodations(String country, String city, double minPrice, double maxPrice, int minRooms) {
        if (country != null && !country.isEmpty() && city != null && !city.isEmpty()) {
            return accommodationRepository.findByCountryAndCityAndPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
                    country, city, minPrice, maxPrice, minRooms);
        } else if (country != null && !country.isEmpty()) {
            return accommodationRepository.findByCountryAndPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
                    country, minPrice, maxPrice, minRooms);
        } else if (city != null && !city.isEmpty()) {
            return accommodationRepository.findByCityAndPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
                    city, minPrice, maxPrice, minRooms);
        } else {
            return accommodationRepository.findByPricePerNightBetweenAndAvailableRoomsGreaterThanEqual(
                    minPrice, maxPrice, minRooms);
        }
    }
}
