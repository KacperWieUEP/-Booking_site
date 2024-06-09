
/*
package com.uep.wap.Seeders;

import com.uep.wap.model.Accommodation;
import com.uep.wap.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create example accommodations
        Accommodation accommodation1 = new Accommodation();
        accommodation1.setName("Sunshine Resort");
        accommodation1.setDescription("A beautiful resort with scenic views.");
        accommodation1.setAddress("123 Sunshine St");
        accommodation1.setCity("Los Angeles");
        accommodation1.setCountry("USA");
        accommodation1.setPricePerNight(new BigDecimal("150.00"));
        accommodation1.setTotalRooms(50);
        accommodation1.setAvailableRooms(30);
        accommodation1.setCreatedAt(LocalDateTime.now());
        accommodation1.setUpdatedAt(LocalDateTime.now());

        Accommodation accommodation2 = new Accommodation();
        accommodation2.setName("Mountain View Inn");
        accommodation2.setDescription("A cozy inn with mountain views.");
        accommodation2.setAddress("456 Mountain Rd");
        accommodation2.setCity("Denver");
        accommodation2.setCountry("USA");
        accommodation2.setPricePerNight(new BigDecimal("120.00"));
        accommodation2.setTotalRooms(20);
        accommodation2.setAvailableRooms(10);
        accommodation2.setCreatedAt(LocalDateTime.now());
        accommodation2.setUpdatedAt(LocalDateTime.now());

        Accommodation accommodation3 = new Accommodation();
        accommodation3.setName("Ocean Breeze Hotel");
        accommodation3.setDescription("A luxurious hotel by the ocean.");
        accommodation3.setAddress("789 Ocean Ave");
        accommodation3.setCity("Miami");
        accommodation3.setCountry("USA");
        accommodation3.setPricePerNight(new BigDecimal("200.00"));
        accommodation3.setTotalRooms(100);
        accommodation3.setAvailableRooms(80);
        accommodation3.setCreatedAt(LocalDateTime.now());
        accommodation3.setUpdatedAt(LocalDateTime.now());

        // Save accommodations to the database
        accommodationRepository.saveAll(Arrays.asList(accommodation1, accommodation2, accommodation3));
    }
}
*/