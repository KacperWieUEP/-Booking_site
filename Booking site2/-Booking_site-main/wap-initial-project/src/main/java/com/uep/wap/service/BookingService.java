package com.uep.wap.service;

import com.uep.wap.model.AppUser;
import com.uep.wap.model.Accommodation;
import com.uep.wap.model.Booking;
import com.uep.wap.repository.AccommodationRepository;
import com.uep.wap.repository.BookingRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking createBooking(Long userId, Long accommodationId, LocalDate checkInDate, LocalDate checkOutDate) {
        Optional<AppUser> userOpt = userRepository.findById(userId);
        Optional<Accommodation> accommodationOpt = accommodationRepository.findById(accommodationId);

        if (userOpt.isPresent() && accommodationOpt.isPresent()) {
            AppUser user = userOpt.get();
            Accommodation accommodation = accommodationOpt.get();

            AppUser user1;

            // Check if there are available rooms
            if (accommodation.getAvailableRooms() < 1) {
                throw new IllegalArgumentException("No available rooms");
            }

            long daysBetween = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
            double totalPrice = daysBetween * accommodation.getPricePerNight();

            Booking booking = new Booking();
            booking.setUser(user);
            booking.setAccommodation(accommodation);
            booking.setCheckInDate(checkInDate);
            booking.setCheckOutDate(checkOutDate);
            booking.setTotalPrice(totalPrice);

            // Decrease available rooms by 1
            accommodation.setAvailableRooms(accommodation.getAvailableRooms() - 1);
            accommodationRepository.save(accommodation);

            return bookingRepository.save(booking);
        } else {
            throw new IllegalArgumentException("User or accommodation not found");
        }
    }

    /*

    public List<Booking> getBookingsByUserIdAndAccommodationId(Long userId, Long accommodationId) {
        return bookingRepository.findByUserIdAndAccommodationId(userId, accommodationId);
    }

     */
}
