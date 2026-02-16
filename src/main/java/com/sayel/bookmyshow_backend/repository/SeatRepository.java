package com.sayel.bookmyshow_backend.repository;

import com.sayel.bookmyshow_backend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findByShow_IdAndSeatNumberIn(Long showId, List<String> seatNumbers);
    List<Seat> findByBooking_Id(Long bookingId);


}
