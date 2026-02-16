package com.sayel.bookmyshow_backend.service;

import com.sayel.bookmyshow_backend.entity.*;
import com.sayel.bookmyshow_backend.repository.BookingRepository;
import com.sayel.bookmyshow_backend.repository.PaymentRepository;
import com.sayel.bookmyshow_backend.repository.SeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final SeatRepository seatRepository;

    public PaymentService(PaymentRepository paymentRepository, BookingRepository bookingRepository, SeatRepository seatRepository) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }
    @Transactional
    public Payment processPayment(Long bookingId, boolean paymentSuccess){
        Booking booking =bookingRepository.findById(bookingId)
                .orElseThrow(()-> new RuntimeException("Booking Not Found"));
        if(booking.getStatus() != BookingStatus.PENDING){
            throw new RuntimeException("Booking already processed");
        }

        Payment payment =Payment.builder()
                .amount(booking.getTotalAmount())
                .paymentTime(LocalDateTime.now())
                .status(paymentSuccess? PaymentStatus.SUCCESS : PaymentStatus.FAILED)
                .bookings(booking)
                .build();
        paymentRepository.save(payment);
        List<Seat> seats =
                seatRepository.findByBooking_Id(bookingId);

        if(paymentSuccess){
            booking.setStatus(BookingStatus.CONFIRMED);
            for(Seat seat: seats){
                seat.setStatus(SeatStatus.BOOKED);
            }
        }else{
            booking.setStatus(BookingStatus.CANCELLED);
            for(Seat seat: seats){
                seat.setStatus(SeatStatus.AVAILABLE);
                seat.setBooking(null);
            }
        }
        return payment;
    }
}
