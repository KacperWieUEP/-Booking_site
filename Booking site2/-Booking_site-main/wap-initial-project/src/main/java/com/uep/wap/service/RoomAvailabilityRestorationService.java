package com.uep.wap.service;

import com.uep.wap.model.Accommodation;
import com.uep.wap.model.Booking;
import com.uep.wap.repository.BookingRepository;
import com.uep.wap.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomAvailabilityRestorationService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Scheduled(cron = "0 0 0 * * ?") // Runs every day at midnight
    public void restoreRoomAvailability() {
        List<Booking> bookings = bookingRepository.findAll();
        LocalDate today = LocalDate.now();

        for (Booking booking : bookings) {
            if (booking.getCheckOutDate().isBefore(today)) {
                Accommodation accommodation = booking.getAccommodation();
                accommodation.setAvailableRooms(accommodation.getAvailableRooms() + 1);
                accommodationRepository.save(accommodation);

            }
        }
    }
}
