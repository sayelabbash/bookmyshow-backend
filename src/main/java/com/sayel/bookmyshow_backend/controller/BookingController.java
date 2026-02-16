package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.Booking;
import com.sayel.bookmyshow_backend.dto.BookingRequest;
import com.sayel.bookmyshow_backend.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request){
        return bookingService.createBooking(
                request.getUserId(),
                request.getShowId(),
                request.getSeatNumbers());
    }
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

}
