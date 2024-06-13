
/*
package com.uep.wap.controller;

import com.uep.wap.model.Review;
import com.uep.wap.model.Booking;
import com.uep.wap.model.AppUser;
import com.uep.wap.model.Accommodation;
import com.uep.wap.service.BookingService;
import com.uep.wap.service.ReviewService;
import com.uep.wap.service.UserService;
import com.uep.wap.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private AccommodationService accommodationService;

    @PostMapping
    public ResponseEntity<String> postReview(@RequestParam Long userId,
                                             @RequestParam Long accommodationId,
                                             @RequestParam String comment,
                                             @RequestParam int rating) {

        // Check if the user has completed a booking for the accommodation
        List<Booking> bookings = bookingService.getBookingsByUserIdAndAccommodationId(userId, accommodationId);
        LocalDate today = LocalDate.now();

        boolean hasCompletedBooking = bookings.stream()
                .anyMatch(booking -> booking.getCheckOutDate().isBefore(today));

        if (hasCompletedBooking) {
            Optional<AppUser> userOpt = userService.getUserById(userId);
            Optional<Accommodation> accommodationOpt = accommodationService.getAccommodationById(accommodationId);

            if (userOpt.isPresent() && accommodationOpt.isPresent()) {
                Review review = new Review();
                review.setUser(userOpt.get());
                review.setAccommodation(accommodationOpt.get());
                review.setComment(comment);
                review.setRating(rating);

                reviewService.saveReview(review);
                return new ResponseEntity<>("Review posted successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("User or accommodation not found", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("User has not completed a booking for this accommodation", HttpStatus.FORBIDDEN);
        }
    }
}


 */