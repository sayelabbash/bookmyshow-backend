package com.sayel.bookmyshow_backend.service;
import com.sayel.bookmyshow_backend.entity.*;
import com.sayel.bookmyshow_backend.repository.BookingRepository;
import com.sayel.bookmyshow_backend.repository.SeatRepository;
import com.sayel.bookmyshow_backend.repository.ShowRepository;
import com.sayel.bookmyshow_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BookingService {
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;
    private final BookingRepository bookingRepository;

    public BookingService(SeatRepository seatRepository, UserRepository userRepository, ShowRepository showRepository, BookingRepository bookingRepository) {
        this.seatRepository = seatRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.bookingRepository = bookingRepository;
    }


    @Transactional
    public Booking createBooking(Long userId, Long showId,
                                 List<String> seatNumbers)
    {
        List<Seat> seats =seatRepository.findByShow_IdAndSeatNumberIn(showId,seatNumbers);
        if (seats.size() != seatNumbers.size()) {
            throw new RuntimeException("Some seats not found");
        }
        for(Seat seat: seats){
            if(seat.getStatus() != SeatStatus.AVAILABLE){
                throw new RuntimeException(
                        "Seat "+seat.getSeatNumber()+" is not available"
                );
            }
        }

        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));
        Show show = showRepository.findById(showId)
                .orElseThrow(()->new RuntimeException("Show not found"));

        Booking booking =Booking.builder()
                .bookingTime(LocalDateTime.now())
                .status(BookingStatus.PENDING)
                .totalAmount(show.getPrice()*seats.size())
                .user(user)
                .show(show)
                .build();

        Booking savedBooking = bookingRepository.save(booking);

        for (Seat seat : seats) {
            seat.setStatus(SeatStatus.LOCKED);
            seat.setBooking(savedBooking);
        }

        return savedBooking;
    }
    public Booking getBookingById(Long bookingId) {

        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

}
