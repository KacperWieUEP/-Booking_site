package com.uep.wap.controller;

import com.uep.wap.model.Booking;
import com.uep.wap.service.BookingService;
import com.uep.wap.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private PdfService pdfService;

    @PostMapping
    public ResponseEntity<byte[]> createBooking(
            @RequestParam Long userId,
            @RequestParam Long accommodationId,
            @RequestParam String checkInDate,
            @RequestParam String checkOutDate) {

        Booking booking = bookingService.createBooking(
                userId,
                accommodationId,
                LocalDate.parse(checkInDate),
                LocalDate.parse(checkOutDate)
        );

        byte[] pdfData = pdfService.generateInvoice(booking);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "invoice.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(pdfData);
    }
}
