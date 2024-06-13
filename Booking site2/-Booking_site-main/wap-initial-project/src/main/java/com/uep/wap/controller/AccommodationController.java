package com.uep.wap.controller;

import com.uep.wap.model.Accommodation;
import com.uep.wap.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accommodations")
public class AccommodationController {
    private static final Logger logger = LoggerFactory.getLogger(AccommodationController.class);

    @Autowired
    private AccommodationService accommodationService;

    @GetMapping
    public List<Accommodation> getAllAccommodations() {
        logger.info("Fetching all accommodations");
        return accommodationService.getAllAccommodations();
    }

    @GetMapping("/{id}")
    public Optional<Accommodation> getAccommodationById(@PathVariable Long id) {
        logger.info("Fetching accommodation with id: {}", id);
        return accommodationService.getAccommodationById(id);
    }

    @PostMapping
    public Accommodation saveAccommodation(@RequestBody Accommodation accommodation) {
        logger.info("Saving new accommodation: {}", accommodation);
        return accommodationService.saveAccommodation(accommodation);
    }

    @DeleteMapping("/{id}")
    public void deleteAccommodation(@PathVariable Long id) {
        logger.info("Deleting accommodation with id: {}", id);
        accommodationService.deleteAccommodation(id);
    }

    @GetMapping("/filter")
    public List<Accommodation> filterAccommodations(
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") double minPrice,
            @RequestParam(defaultValue = "Double.MAX_VALUE") double maxPrice,
            @RequestParam(defaultValue = "1") int minRooms) {
        logger.info("Filtering accommodations with parameters - Country: {}, City: {}, Price between {} and {}, Minimum rooms: {}",
                country, city, minPrice, maxPrice, minRooms);
        return accommodationService.filterAccommodations(country, city, minPrice, maxPrice, minRooms);
    }
}
